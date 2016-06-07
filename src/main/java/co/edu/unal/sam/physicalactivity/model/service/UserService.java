package co.edu.unal.sam.physicalactivity.model.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.exception.BusinessException;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;
import co.edu.unal.sam.aspect.model.repository.UserRepository;
import co.edu.unal.sam.physicalactivity.model.domain.Bmi;
import co.edu.unal.sam.physicalactivity.model.domain.PhysicalActivity;
import co.edu.unal.sam.physicalactivity.model.dto.DiseaseDto;
import co.edu.unal.sam.physicalactivity.model.enumerator.BmiCategoryEnum;
import co.edu.unal.sam.physicalactivity.model.enumerator.TypeRiskEnum;
import co.edu.unal.sam.physicalactivity.model.repository.UserDiseaseRepository;

/**
 * 
 * @author Andrés Mise Olivera
 *
 */
@Component
public class UserService {

    @Inject
    private UserRepository repository;

    @Inject
    private UserDiseaseRepository userDiseaseRepository;

    /**
     * Classify an User
     * 
     * @param user to classify
     */
    public void classifyUser(final User user) {
        final Bmi bmi = this.calculateBmi(user);
        this.calculateRisk(user, bmi.getCategory());
        // TODO realizar logica de guardado del bmi
    }

    /**
     * Create a user.
     * 
     * @param user to create
     * @return user created
     */
    public User createUser(final User user) {
        if (TypeUserEnum.PLAYER.equals(user.getTypeuser()) && Objects.isNull(user.getFaculty())) {
            throw new BusinessException("NotNull.user.faculty", HttpStatus.BAD_REQUEST);
        }
        if (this.repository.findByIdentityDocument(user.getIdentityDocument()) != null) {
            throw new BusinessException("Existent.user.identityDocument", HttpStatus.BAD_REQUEST);
        }
        String cryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(cryptedPassword);
        return this.repository.save(user);
    }

    public Iterable<DiseaseDto> getDiseases(User user, StateEnum state) {
        if (state == null) {
            state = StateEnum.ACTIVE;
        }
        return this.userDiseaseRepository.findDiseaseDtoByUser(user.getId(), state);

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

    private Bmi calculateBmi(final User user) {
        Set<Bmi> bmis = user.getBmis();
        if (!bmis.isEmpty()) {
            Bmi bmi = Collections.max(bmis, Comparator.comparing(b -> b.getDateRegister()));
            final Float height = bmi.getHeight();
            final Float weight = bmi.getWeight();
            if (weight == null && height == null) {
                throw new BusinessException("NotNull.user.height_weight", HttpStatus.BAD_REQUEST);
            } else if (height == null || Float.valueOf(0).equals(height)) {
                throw new BusinessException("NotNull.user.height", HttpStatus.BAD_REQUEST);
            } else if (weight == null) {
                throw new BusinessException("NotNull.user.weight", HttpStatus.BAD_REQUEST);
            }
            Float value = new Float((weight / Math.pow(height, 2D)));
            bmi.setBmi(value);
            bmi.setCategory(BmiCategoryEnum.getCategory(value));
            return bmi;
        }
        throw new BusinessException("NotNull.user.height_weight", HttpStatus.BAD_REQUEST);
    }

    private TypeRiskEnum calculateRisk(User user, BmiCategoryEnum bmi) {
        TypeRiskEnum risk;
        Set<PhysicalActivity> activities = user.getPhysicalActivities();
        if (!user.getDiseases().isEmpty()) {
            risk = TypeRiskEnum.INDETERMINATE;
        } else if (activities.isEmpty()) {
            risk = TypeRiskEnum.HIGH;
        } else {
            PhysicalActivity activity =
                    Collections.max(activities, Comparator.comparing(pa -> pa.getDateRegister()));
            int minutes = activity.getNumberHours() * activity.getNumberHours();
            if (this.isObese(bmi) || Integer.valueOf("1").equals(activity.getNumberDays())) {
                risk = TypeRiskEnum.HIGH;
            } else if (minutes >= 150) {
                if (BmiCategoryEnum.OVERWEIGHT.equals(bmi)) {
                    risk = TypeRiskEnum.MEDIUM;
                } else {
                    risk = TypeRiskEnum.LOW;
                }
            } else if (minutes >= 100) {
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
