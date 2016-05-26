package co.edu.unal.sam.physicalactivity.model.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.exception.BusinessException;
import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;
import co.edu.unal.sam.aspect.model.repository.UserRepository;
import co.edu.unal.sam.physicalactivity.model.domain.PhysicalActivity;
import co.edu.unal.sam.physicalactivity.model.enumerator.BmiCategoryEnum;
import co.edu.unal.sam.physicalactivity.model.enumerator.TypeRiskEnum;

/**
 * 
 * @author Andrés Mise Olivera
 *
 */
@Component
public class UserService {

    @Inject
    private UserRepository userRepository;

    /**
     * Classify an User
     * 
     * @param user to classify
     */
    public void classifyUser(final User user) {
        final Float bmi = this.calculateBmi(user.getWeight(), user.getHeight());
        final BmiCategoryEnum bmiCategory = BmiCategoryEnum.getCategory(bmi);
        this.calculateRisk(user.getPhysicalActivities(), bmiCategory);
        user.setBmi(bmi);
        this.userRepository.setBmiInfoById(user.getWeight(), user.getHeight(), user.getBmi(),
                user.getId());
    }

    /**
     * Create a user.
     * 
     * @param user to create
     * @return user created
     */
    public User createUser(final User user) {
        String cryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(cryptedPassword);
        if (TypeUserEnum.PLAYER.equals(user.getTypeuser()) && Objects.isNull(user.getFaculty())) {
            throw new BusinessException("NotNull.user.faculty");
        }
        return this.userRepository.save(user);
    }

    private Float calculateBmi(final Float weight, final Float height) {
        if (weight == null && height == null) {
            throw new BusinessException("NotNull.user.height_weight");
        } else if (height == null || Float.valueOf(0).equals(height)) {
            throw new BusinessException("NotNull.user.height");
        } else if (weight == null) {
            throw new BusinessException("NotNull.user.weight");
        }

        return new Float((weight / Math.pow(height, 2D)));
    }

    private TypeRiskEnum calculateRisk(Set<PhysicalActivity> physicalActivities,
            BmiCategoryEnum bmi) {
        // TODO: determinar riesgo segun variables
        TypeRiskEnum risk = null;
        if (physicalActivities.isEmpty()) {
            throw new BusinessException("NotEmpty.user.physicalActivities");
        }
        PhysicalActivity activity = Collections.max(physicalActivities,
                Comparator.comparing(pa -> pa.getDateRegister()));
        if (this.isObese(bmi) || Integer.valueOf("1").equals(activity.getNumberDays())) {
            risk = TypeRiskEnum.HIGH;
        }
        return risk;
    }

    private boolean isObese(BmiCategoryEnum bmi) {
        return BmiCategoryEnum.OBESE_CLASS_I.equals(bmi)
                || BmiCategoryEnum.OBESE_CLASS_II.equals(bmi)
                || BmiCategoryEnum.OBESE_CLASS_III.equals(bmi);
    }

}
