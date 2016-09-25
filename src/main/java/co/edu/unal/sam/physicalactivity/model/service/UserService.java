package co.edu.unal.sam.physicalactivity.model.service;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.google.common.collect.Sets;

import co.edu.unal.sam.aspect.exception.BusinessException;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;
import co.edu.unal.sam.aspect.model.repository.UserRepository;
import co.edu.unal.sam.physicalactivity.model.domain.Activity;
import co.edu.unal.sam.physicalactivity.model.domain.Bmi;
import co.edu.unal.sam.physicalactivity.model.domain.Disease;
import co.edu.unal.sam.physicalactivity.model.domain.Goal;
import co.edu.unal.sam.physicalactivity.model.domain.PhysicalActivity;
import co.edu.unal.sam.physicalactivity.model.domain.UserDisease;
import co.edu.unal.sam.physicalactivity.model.domain.UserGoalActivity;
import co.edu.unal.sam.physicalactivity.model.dto.ActivityDto;
import co.edu.unal.sam.physicalactivity.model.dto.DiseaseDto;
import co.edu.unal.sam.physicalactivity.model.dto.GoalDto;
import co.edu.unal.sam.physicalactivity.model.dto.UserDto;
import co.edu.unal.sam.physicalactivity.model.enumerator.BmiCategoryEnum;
import co.edu.unal.sam.physicalactivity.model.enumerator.IntensityEnum;
import co.edu.unal.sam.physicalactivity.model.enumerator.TypeRiskEnum;
import co.edu.unal.sam.physicalactivity.model.repository.ActivityRepository;
import co.edu.unal.sam.physicalactivity.model.repository.BmiRepository;
import co.edu.unal.sam.physicalactivity.model.repository.DiseaseRepository;
import co.edu.unal.sam.physicalactivity.model.repository.GoalRepository;
import co.edu.unal.sam.physicalactivity.model.repository.PhysicalActivityRepository;
import co.edu.unal.sam.physicalactivity.model.repository.UserDiseaseRepository;
import co.edu.unal.sam.physicalactivity.model.repository.UserGoalActivityRepository;

/**
 * 
 * @author Andrés Mise Olivera
 *
 */
@Component
public class UserService {

    @Inject
    private ActivityRepository activityRepository;

    @Inject
    private BmiRepository bmiRepository;

    @Inject
    private DiseaseRepository diseaseRepository;

    @Inject
    private GoalRepository goalRepository;

    @Inject
    private PhysicalActivityRepository physicalActivityRepository;

    @Inject
    private UserRepository repository;

    @Inject
    private UserDiseaseRepository userDiseaseRepository;

    @Inject
    private UserGoalActivityRepository userGoalRepository;

    /**
     * Classify an User
     * 
     * @param user to classify
     */
    public TypeRiskEnum classifyUser(final User user) {
        // TODO cambiar respuesta del metodo
        Set<Bmi> bmis = this.bmiRepository.findByUser(user);
        Bmi bmi = Collections.max(bmis, Comparator.comparing(b -> b.getDateRegister()));
        TypeRiskEnum risk = this.calculateRisk(user, bmi.getCategory());
        bmi.setRisk(risk);
        this.bmiRepository.save(bmi);
        this.physicalActivityRepository.deleteByUser(user);
        this.physicalActivityRepository.save(user.getPhysicalActivities());
        return risk;
    }

    /**
     * Create a user.
     * 
     * @param user to create
     * @return user created
     */
    public User createUser(User user) {
        if (TypeUserEnum.PLAYER.equals(user.getTypeuser()) && Objects.isNull(user.getFaculty())) {
            throw new BusinessException("NotNull.user.faculty", HttpStatus.BAD_REQUEST);
        }
        if (this.repository.findByIdentityDocumentOrUsername(user.getIdentityDocument(),
                user.getUsername()) != null) {
            throw new BusinessException("Existent.user.identityDocument", HttpStatus.BAD_REQUEST);
        }
        String cryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(cryptedPassword);
        user = this.repository.save(user);
        if (!user.getBmis().isEmpty()) {
            this.calculateBmi(user);
            this.bmiRepository.save(user.getBmis());
        }
        return user;
    }

    public User createGoals(Set<GoalDto> goalsDto, Long userId) {
        User user = this.verify(userId);
        List<Long> ids = new ArrayList<>();
        for (GoalDto dto : goalsDto) {
            if (Boolean.TRUE.equals(dto.getSelected())) {
                ids.add(dto.getId());
            }
        }
        Iterable<Goal> goals = this.goalRepository.findAll(ids);
        Date date = user.getDateExpireClasification();
        LocalDate expireClasification = new java.sql.Date(date.getTime()).toLocalDate();
        user.setDateExpireClasification(java.sql.Date.valueOf(expireClasification.plusMonths(3)));
        user.setGoals(Sets.newHashSet(goals));
        this.repository.save(user);
        return null;
    }

    public User updateGoals(UserDto userDto) {
        User user = this.verify(userDto.getId());
        List<UserGoalActivity> goals = new ArrayList<>();
        UserGoalActivity goal;
        Activity activity;
        Goal g;
        for (GoalDto dto : userDto.getGoals()) {
            goal = new UserGoalActivity();
            g = new Goal();
            g.setId(dto.getId());
            activity = new Activity();
            activity.setId(dto.getActivity().getId());
            goal.setActivity(activity);
            goal.setUser(user);
            goal.setGoal(g);
            goal.setMinutes(dto.getMinutes());
            goal.setDays(dto.getDays());
            goal.setName(dto.getActivity().getName());
            goals.add(goal);
        }
        LocalDate now = LocalDate.now();
        TemporalField fieldISO = WeekFields.of(Locale.forLanguageTag("es-co")).dayOfWeek();
        this.userGoalRepository.deleteByUserAndDateRegister(user,
                java.sql.Date.valueOf(now.with(fieldISO, 1)));
        this.userGoalRepository.save(goals);
        return user;
    }

    public List<ActivityDto> getActivities(User user, StateEnum state, Boolean onlySelected) {
        if (state == null) {
            state = StateEnum.ACTIVE;
        }
        List<ActivityDto> activitiesSelected =
                this.physicalActivityRepository.findActivityDtoByStateAndUser(state, user);
        List<Activity> activities = this.activityRepository.findByState(state);
        List<ActivityDto> activitiesDto = new ArrayList<>();
        if (Boolean.TRUE.equals(onlySelected)) {
            activitiesDto = activitiesSelected;
        } else {
            ActivityDto dto;
            for (Activity a : activities) {
                dto = new ActivityDto(a.getId(), a.getName(), false);
                for (ActivityDto d : activitiesSelected) {
                    if (a.getId().equals(d.getId())) {
                        dto.setName(d.getName());
                        dto.setSelected(true);
                    }
                }
                if (dto.getId().equals(1L) && !dto.getSelected()) {
                    continue;
                }
                activitiesDto.add(dto);
            }
        }
        return activitiesDto;
    }

    public Iterable<DiseaseDto> getDiseases(User user, StateEnum state, Boolean onlySelected) {
        if (state == null) {
            state = StateEnum.ACTIVE;
        }
        List<DiseaseDto> diseasesSelected =
                this.userDiseaseRepository.findDiseaseDtoByStateAndUser(state, user);
        List<DiseaseDto> diseasesDto = new ArrayList<>(0);
        List<Disease> diseases = this.diseaseRepository.findByState(state);
        if (Boolean.TRUE.equals(onlySelected)) {
            diseasesDto = diseasesSelected;
        } else {
            DiseaseDto dto;
            for (Disease a : diseases) {
                dto = new DiseaseDto(a.getId(), a.getName(), false);
                for (DiseaseDto d : diseasesSelected) {
                    if (a.getId().equals(d.getId())) {
                        dto.setName(d.getName());
                        dto.setSelected(true);
                    }
                }
                if (dto.getId().equals(1L) && !dto.getSelected()) {
                    continue;
                }
                diseasesDto.add(dto);
            }
        }
        return diseasesDto;
    }

    public Bmi preClassifyUser(final User user) {
        Set<Bmi> bmis = this.verify(user.getId()).getBmis();
        Bmi b2 = Collections.max(user.getBmis(), Comparator.comparing(b -> b.getDateRegister()));
        if (!bmis.isEmpty()) {
            Bmi b1 = Collections.max(bmis, Comparator.comparing(b -> b.getDateRegister()));
            if (!b1.getHeight().equals(b2.getHeight()) || !b1.getWeight().equals(b2.getWeight())) {
                this.bmiRepository.save(this.calculateBmi(b2));
            }
        }
        this.physicalActivityRepository.deleteByUser(user);
        this.userDiseaseRepository.deleteByUser(user);
        this.physicalActivityRepository.save(user.getPhysicalActivities());
        this.userDiseaseRepository.save(user.getDiseases());
        return b2;
    }

    public User verify(Long userId) throws ResourceNotFoundException {
        User user = null;
        if (userId != null) {
            user = this.repository.findOne(userId);
            if (user == null) {
                throw new ResourceNotFoundException("User with id " + userId + " not found");
            }
        } else {
            throw new BusinessException("NotNull.user.id", HttpStatus.BAD_REQUEST);
        }
        return user;
    }

    private Bmi calculateBmi(Bmi bmi) {
        final Float height = bmi.getHeight();
        final Float weight = bmi.getWeight();
        if (weight == null && height == null) {
            throw new BusinessException("NotNull.user.height_weight", HttpStatus.BAD_REQUEST);
        } else if (height == null || Float.valueOf(0).equals(height)) {
            throw new BusinessException("NotNull.user.height", HttpStatus.BAD_REQUEST);
        } else if (weight == null) {
            throw new BusinessException("NotNull.user.weight", HttpStatus.BAD_REQUEST);
        }
        if (Objects.isNull(bmi)) {
            bmi = new Bmi();
        }
        Float value = new Float((weight / Math.pow(height, 2D)));
        bmi.setBmi(value);
        bmi.setCategory(BmiCategoryEnum.getCategory(value));
        bmi.setName(bmi.getCategory().getName());
        return bmi;
    }

    private Bmi calculateBmi(final User user) {
        Set<Bmi> bmis = user.getBmis();
        if (!bmis.isEmpty()) {
            Bmi bmi = Collections.max(bmis, Comparator.comparing(b -> b.getDateRegister()));
            return calculateBmi(bmi);
        }
        throw new BusinessException("NotNull.user.height_weight", HttpStatus.BAD_REQUEST);
    }

    private TypeRiskEnum calculateRisk(User user, BmiCategoryEnum bmi) {
        TypeRiskEnum risk;
        Set<PhysicalActivity> activities = user.getPhysicalActivities();
        List<UserDisease> diseases = this.userDiseaseRepository.findByUser(user);
        if (activities.isEmpty()) {
            risk = TypeRiskEnum.HIGH;
        } else {
            int days = 0;
            int minutesModerate = 0;
            int minutesVigorous = 0;
            for (PhysicalActivity activity : activities) {
                days += activity.getDays();
                if (IntensityEnum.MODERATE.equals(activity.getActivity().getIntensity())) {
                    minutesModerate = minutesModerate + activity.getDays() * activity.getMinutes();
                } else {
                    minutesVigorous = minutesModerate + activity.getDays() * activity.getMinutes();
                }
            }
            if (this.isObese(bmi) || days <= 1) {
                risk = TypeRiskEnum.HIGH;
            } else if (minutesModerate >= 150 || minutesVigorous >= 75) {
                if (BmiCategoryEnum.OVERWEIGHT.equals(bmi)) {
                    risk = TypeRiskEnum.MEDIUM;
                } else {
                    risk = TypeRiskEnum.LOW;
                }
            } else if (minutesModerate >= 100 || minutesVigorous >= 50) {
                if (BmiCategoryEnum.OVERWEIGHT.equals(bmi)) {
                    risk = TypeRiskEnum.HIGH;
                } else {
                    risk = TypeRiskEnum.MEDIUM;
                }
            } else {
                risk = TypeRiskEnum.HIGH;
            }
        }
        return risk;
    }

    private boolean isObese(BmiCategoryEnum bmi) {
        return BmiCategoryEnum.OBESE_CLASS_I.equals(bmi)
                || BmiCategoryEnum.OBESE_CLASS_II.equals(bmi)
                || BmiCategoryEnum.OBESE_CLASS_III.equals(bmi);
    }

}
