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

import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.physicalactivity.model.domain.Campus;
import co.edu.unal.sam.physicalactivity.model.domain.Faculty;

@Transactional
public class UserControllerTest extends ControllerTest {

    @SuppressWarnings("unused")
    @Inject
    private UserController controller;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testCreateUser() throws Exception {
        String uri = "/admin/users";

        User user = new User();
        user.setName("Sabit");
        user.setSurname("Inc");
        user.setIdentityDocument("123456789");
        user.setFaculty(this.getFaculty());
        user.setDateBirth(new Date());
        user.setUsername("sabit");
        user.setEmail("contact@sabit.co");
        user.setPassword("******");

        String inputJson = super.mapToJson(user);
        MvcResult result = super.mvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        super.logger.info("test create user result: " + response.getContentAsString());
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

    /**
     * @return
     */
    private Faculty getFaculty() {
        Faculty faculty = new Faculty();
        faculty.setCampus(this.getCampus());
        faculty.setId(1L);
        return faculty;
    }

    /**
     * @return
     */
    private Campus getCampus() {
        Campus campus = new Campus();
        campus.setId(1L);
        return campus;
    }

}
