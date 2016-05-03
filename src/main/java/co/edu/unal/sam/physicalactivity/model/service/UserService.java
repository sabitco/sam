package co.edu.unal.sam.physicalactivity.model.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.model.domain.User;
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
     * Create a user.
     * 
     * @param user to create
     * @return user created
     */
    public User createUser(final User user) {
        String cryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(cryptedPassword);
        return this.userRepository.save(user);
    }

}
