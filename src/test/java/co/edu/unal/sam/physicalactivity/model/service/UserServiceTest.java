package co.edu.unal.sam.physicalactivity.model.service;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unal.sam.ApplicationTests;
import co.edu.unal.sam.aspect.exception.BusinessException;
import co.edu.unal.sam.aspect.model.domain.User;

@Transactional
public class UserServiceTest extends ApplicationTests {

    @Inject
    private UserService userService;

    @Test(expected = BusinessException.class)
    public void testClassifyUserWithoutHeightAndWeight() {
        User user = this.getUser();
        this.userService.classifyUser(user);
    }

    @Test(expected = BusinessException.class)
    public void testClassifyUserWithoutPhysicalActivity() {
        User user = this.getUser();
        user.setWeight(67F);
        user.setHeight(1.60F);
        this.userService.classifyUser(user);
    }

    private User getUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Sabit");
        user.setSurname("Inc");
        user.setIdentityDocument("123456789");
        user.setDateBirth(new Date());
        user.setUsername("sabit");
        user.setEmail("contact@sabit.co");
        user.setPassword("******");
        return user;
    }

}
