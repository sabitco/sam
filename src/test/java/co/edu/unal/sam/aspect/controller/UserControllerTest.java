package co.edu.unal.sam.aspect.controller;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Campus;
import co.edu.unal.sam.physicalactivity.model.domain.Faculty;
import co.edu.unal.sam.physicalactivity.model.domain.PhysicalActivity;

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
    public void testClassifyUser() throws Exception {
        final String uri = "/users/classify";
        User user = this.getUser();
        user.setId(1L);
        user.setWeight(69F);
        user.setHeight(1.60F);
        user.getPhysicalActivities().add(new PhysicalActivity());

        final String inputJson = super.mapToJson(user);
        final MvcResult result = super.mvc
                .perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();
        final MockHttpServletResponse response = result.getResponse();
        final String content = response.getContentAsString();
        user = super.mapFromJson(content, User.class);
        super.logger.info("result test classify user: " + content);
        Assert.assertEquals("Failure - Expected HTTP status 200", HttpStatus.OK.value(),
                response.getStatus());
    }

    @Test
    public void testClassifyUserWithoutId() throws Exception {
        final String uri = "/users/classify";
        User user = this.getUser();
        user.setWeight(60F);
        user.setHeight(1.70F);

        final String inputJson = super.mapToJson(user);
        final MvcResult result = super.mvc
                .perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();
        final MockHttpServletResponse response = result.getResponse();
        final String content = response.getContentAsString();
        super.logger.info("result test classify user without height: " + content);
        Assert.assertEquals("Failure - Expected HTTP status 400", HttpStatus.BAD_REQUEST.value(),
                response.getStatus());
    }

    @Test
    public void testClassifyUserWithoutHeight() throws Exception {
        final String uri = "/users/classify";
        User user = this.getUser();
        user.setId(1L);
        user.setWeight(60F);

        final String inputJson = super.mapToJson(user);
        final MvcResult result = super.mvc
                .perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();
        final MockHttpServletResponse response = result.getResponse();
        final String content = response.getContentAsString();
        super.logger.info("result test classify user without height: " + content);
        Assert.assertEquals("Failure - Expected HTTP status 400", HttpStatus.BAD_REQUEST.value(),
                response.getStatus());
    }

    @Test
    public void testClassifyUserWithoutWeight() throws Exception {
        final String uri = "/users/classify";
        User user = this.getUser();
        user.setId(1L);
        user.setHeight(1.70F);

        final String inputJson = super.mapToJson(user);
        final MvcResult result = super.mvc
                .perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();
        final MockHttpServletResponse response = result.getResponse();
        final String content = response.getContentAsString();
        super.logger.info("result test classify user without height: " + content);
        Assert.assertEquals("Failure - Expected HTTP status 400", HttpStatus.BAD_REQUEST.value(),
                response.getStatus());
    }

    @Test
    public void testCreateUserAdministrator() throws Exception {
        final String uri = "/admin/users";

        final User user = this.getUser();
        user.setTypeuser(TypeUserEnum.ADMINISTRATOR);

        final String inputJson = super.mapToJson(user);
        final MvcResult result = super.mvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();
        final MockHttpServletResponse response = result.getResponse();
        final String content = response.getContentAsString();
        super.logger.info("result test create user administrator: " + content);
        Assert.assertEquals("Failure - Expected HTTP status 201", 201, response.getStatus());
    }

    @Test
    public void testCreateUserPlayer() throws Exception {
        final String uri = "/admin/users";

        final User user = this.getUser();
        user.setTypeuser(TypeUserEnum.PLAYER);
        user.setFaculty(this.getFaculty());

        final String inputJson = super.mapToJson(user);
        final MvcResult result = super.mvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();
        final MockHttpServletResponse response = result.getResponse();
        final String content = response.getContentAsString();
        super.logger.info("result test create user player: " + content);
        Assert.assertEquals("Failure - Expected HTTP status 201", 201, response.getStatus());
    }

    @Test
    public void testGetUsers() throws Exception {
        String uri = "/admin/users";
        MvcResult result = super.mvc
                .perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        final String content = response.getContentAsString();
        super.logger.info("result test get users: " + content);
        Assert.assertEquals("Failure - Expected HTTP status 200", HttpStatus.OK.value(),
                response.getStatus());
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
        Assert.assertEquals("Failure - Expected HTTP status 200", HttpStatus.OK.value(),
                response.getStatus());
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
    private Campus getCampus() {
        Campus campus = new Campus();
        campus.setId(1L);
        return campus;
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
    private User getUser() {
        User user = new User();
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
