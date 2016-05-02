package co.edu.unal.sam.aspect.model.repository;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unal.sam.ApplicationTests;
import co.edu.unal.sam.aspect.model.domain.User;

@Transactional
public class UserRepositoryTest extends ApplicationTests {

    @Inject
    private UserRepository repository;
    
    @Test
    public void testFindAll() {
        Iterable<User> users = this.repository.findAll();
        Assert.assertNotNull("failure - expected not null", users);
    }
    
}
