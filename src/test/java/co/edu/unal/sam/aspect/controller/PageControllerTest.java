package co.edu.unal.sam.aspect.controller;

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

@Transactional
public class PageControllerTest extends ControllerTest {

    @SuppressWarnings("unused")
    @Inject
    private PageController controller;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    
    @Test
    public void testGetPageByBase() throws Exception {
        String uri = "/pages/{base}";
        String base = "page";
        MvcResult result = super.mvc
                .perform(MockMvcRequestBuilders.get(uri, base).accept(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        super.logger.info("result test get page by base: " + response.getContentAsString());
        Assert.assertEquals("Failure - Expected HTTP status 200", HttpStatus.OK.value(),
                response.getStatus());
        Assert.assertTrue("Failure - Expected HTTP response body to have a value",
                response.getContentAsString().length() > 0);
    }

}
