package co.edu.unal.sam.physicalactivity.model.service;

import java.util.Objects;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.exception.BusinessException;
import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;
import co.edu.unal.sam.aspect.model.repository.UserRepository;

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
     * @param user
     * @return
     */
    public void classifyUser(final User user) {
        final Double bmi = this.classifyUser(user.getWeight(), user.getHeight());
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

    private Double classifyUser(Integer weight, Float height) {
        if (weight == null && height == null) {
            throw new BusinessException("NotNull.user.height_weight");
        } else if (height == null || Float.valueOf(0).equals(height)) {
            throw new BusinessException("NotNull.user.weight");
        } else if (weight == null) {
            throw new BusinessException("NotNull.user.weight");
        }

        return (weight / Math.pow(height, 2D));
    }

}
