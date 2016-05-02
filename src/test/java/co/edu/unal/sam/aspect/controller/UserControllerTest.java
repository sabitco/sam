package co.edu.unal.sam.aspect.controller;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unal.sam.aspect.model.domain.Role;
import co.edu.unal.sam.aspect.model.domain.User;

@Transactional
public class UserControllerTest extends ControllerTest {

    @SuppressWarnings("unused")
    @Inject
    private UserController controller;

    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testCreateUser() throws Exception {
        String uri = "/admin/users";
        User user = new User();
        user.setBmi(24);
        user.setDateBirth(new Date());
        user.setDateIngress(new Date());
        user.setDateInteraction(new Date());
        user.setDateRegister(new Date());
        user.setDateUpdate(new Date());
        user.setEmail("j4m0@outlook.com");
        user.setHeight(170);
        user.setHistory(true);
        user.setName("j4m0");
        user.setPassword("******");
        user.setUsername("username");
        user.setRole(new Role());
        user.getRole().setId(1L);
        user.setDescriptionHistory("history");
        String inputJson = super.mapToJson(user);
        MvcResult result = super.mvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals("Failure - Expected HTTP status 201", 201, response.getStatus());
    }

    @Test
    public void testGetUsers() throws Exception {
        String uri = "/admin/users";
        MvcResult result = super.mvc
                .perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        super.logger.info(response.getContentAsString());
        Assert.assertEquals("Failure - Expected HTTP status 200", 200, response.getStatus());
        Assert.assertTrue("Failure - Expected HTTP response body to have a value",
                response.getContentAsString().length() > 0);
    }

    @Test
    public void testGetUser() throws Exception {
        String uri = "/admin/users/{userId}";
        Long userId = 1L;
        MvcResult result = super.mvc
                .perform(MockMvcRequestBuilders.get(uri, userId).accept(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        super.logger.info(response.getContentAsString());
        Assert.assertEquals("Failure - Expected HTTP status 200", 200, response.getStatus());
        Assert.assertTrue("Failure - Expected HTTP response body to have a value",
                response.getContentAsString().length() > 0);
    }

    @Test
    public void testGetUserNotFound() throws Exception {
        String uri = "/admin/users/{userId}";
        Long userId = Long.MAX_VALUE;
        MvcResult result = super.mvc
                .perform(MockMvcRequestBuilders.get(uri, userId).accept(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        super.logger.info(response.getContentAsString());
        Assert.assertEquals("Failure - Expected HTTP status 404", 404, response.getStatus());
    }

}
