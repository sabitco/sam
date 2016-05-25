package co.edu.unal.sam.physicalactivity.controller ;

import org.junit.Assert ;
import org.junit.Before ;
import org.junit.Test ;
import org.springframework.http.HttpStatus ;
import org.springframework.http.MediaType ;
import org.springframework.mock.web.MockHttpServletResponse ;
import org.springframework.test.web.servlet.MvcResult ;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders ;

import co.edu.unal.sam.aspect.controller.ControllerTest ;
import co.edu.unal.sam.aspect.model.enumerator.StateEnum ;

public class CampusControllerTest extends ControllerTest {
  
  @Before
  @Override
  public void setUp() {
	super.setUp() ;
  }
  
  @Test
  public void testGetCampus() throws Exception {
	final String uri = "/campus" ;
	final MvcResult result =
	    super.mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
	        .andReturn() ;
	final MockHttpServletResponse response = result.getResponse() ;
	final String content = response.getContentAsString() ;
	super.logger.info("result test get campus: " + content) ;
	Assert.assertEquals("Failure - Expected HTTP status 200", HttpStatus.OK.value(),
	    response.getStatus()) ;
	Assert.assertTrue("Failure - Expected HTTP response body to have a value", response
	    .getContentAsString().length() > 0) ;
  }
  
  @Test
  public void testGetCampusByStateActive() throws Exception {
	final String uri = "/campus?state={state}" ;
	final MvcResult result =
	    super.mvc.perform(
	        MockMvcRequestBuilders.get(uri, StateEnum.ACTIVE).accept(MediaType.APPLICATION_JSON))
	        .andReturn() ;
	final MockHttpServletResponse response = result.getResponse() ;
	final String content = response.getContentAsString() ;
	super.logger.info("result test get campus active: " + content) ;
	Assert.assertEquals("Failure - Expected HTTP status 200", HttpStatus.OK.value(),
	    response.getStatus()) ;
	Assert.assertTrue("Failure - Expected HTTP response body to have a value", response
	    .getContentAsString().length() > 0) ;
  }
  
  @Test
  public void testGetCampusByStateInactive() throws Exception {
	final String uri = "/campus?state={state}" ;
	final MvcResult result =
	    super.mvc.perform(
	        MockMvcRequestBuilders.get(uri, StateEnum.INACTIVE).accept(MediaType.APPLICATION_JSON))
	        .andReturn() ;
	final MockHttpServletResponse response = result.getResponse() ;
	final String content = response.getContentAsString() ;
	super.logger.info("result test get campus inactive: " + content) ;
	Assert.assertEquals("Failure - Expected HTTP status 200", HttpStatus.OK.value(),
	    response.getStatus()) ;
	Assert.assertTrue("Failure - Expected HTTP response body to have a value", response
	    .getContentAsString().length() > 0) ;
  }
  
  @Test
  public void testGetFaculties() throws Exception {
	final String uri = "/campus/faculties/{campusId}" ;
	final Long campusId = 2L ;
	final MvcResult result =
	    super.mvc.perform(
	        MockMvcRequestBuilders.get(uri, campusId).accept(MediaType.APPLICATION_JSON))
	        .andReturn() ;
	final MockHttpServletResponse response = result.getResponse() ;
	super.logger.info("result test get faculties: " + response.getContentAsString()) ;
	Assert.assertEquals("Failure - Expected HTTP status 200", HttpStatus.OK.value(),
	    response.getStatus()) ;
	Assert.assertTrue("Failure - Expected HTTP response body to have a value", response
	    .getContentAsString().length() > 0) ;
  }
  
  @Test
  public void testGetFacultiesByStateActive() throws Exception {
	final String uri = "/campus/{campusId}/faculties?state={state}" ;
	final Long campusId = 2L ;
	final MvcResult result =
	    super.mvc.perform(
	        MockMvcRequestBuilders.get(uri, campusId, StateEnum.ACTIVE).accept(
	            MediaType.APPLICATION_JSON)).andReturn() ;
	final MockHttpServletResponse response = result.getResponse() ;
	super.logger.info("result test get faculties Active: " + response.getContentAsString()) ;
	Assert.assertEquals("Failure - Expected HTTP status 200", HttpStatus.OK.value(),
	    response.getStatus()) ;
	Assert.assertTrue("Failure - Expected HTTP response body to have a value", response
	    .getContentAsString().length() > 0) ;
  }
  
  @Test
  public void testGetFacultiesByStateInactive() throws Exception {
	final String uri = "/campus/{campusId}/faculties?state={state}" ;
	final Long campusId = 2L ;
	final MvcResult result =
	    super.mvc.perform(
	        MockMvcRequestBuilders.get(uri, campusId, StateEnum.INACTIVE).accept(
	            MediaType.APPLICATION_JSON)).andReturn() ;
	final MockHttpServletResponse response = result.getResponse() ;
	super.logger.info("result test get faculties inactive: " + response.getContentAsString()) ;
	Assert.assertEquals("Failure - Expected HTTP status 200", HttpStatus.OK.value(),
	    response.getStatus()) ;
	Assert.assertTrue("Failure - Expected HTTP response body to have a value", response
	    .getContentAsString().length() > 0) ;
  }
  
}
