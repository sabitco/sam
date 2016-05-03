package co.edu.unal.sam.aspect.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.inject.Inject;

import org.junit.Before;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.unal.sam.ApplicationTests;

@WebAppConfiguration
public abstract class ControllerTest extends ApplicationTests {

    protected MockMvc mvc;

    @Inject
    protected WebApplicationContext webApplicationContext;

    private ObjectMapper mapper;

    @Before
    protected void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        this.mapper = new ObjectMapper();
        this.mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    }

    protected String mapToJson(Object object) throws JsonProcessingException {
        return this.mapper.writeValueAsString(object);
    }

    protected <T> T mapFromJson(String json, Class<T> valueType)
            throws JsonParseException, JsonMappingException, IOException {
        return this.mapper.readValue(json, valueType);
    }

}
