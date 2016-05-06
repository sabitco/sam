package co.edu.unal.sam.aspect.controller ;

import java.net.URI ;

import javax.inject.Inject ;
import javax.validation.Valid ;

import org.springframework.data.domain.Pageable ;
import org.springframework.http.HttpHeaders ;
import org.springframework.http.HttpStatus ;
import org.springframework.http.ResponseEntity ;
import org.springframework.web.bind.annotation.PathVariable ;
import org.springframework.web.bind.annotation.RequestBody ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestMethod ;
import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder ;

import co.edu.unal.sam.aspect.exception.ResourceNotFoundException ;
import co.edu.unal.sam.aspect.model.domain.Page ;
import co.edu.unal.sam.aspect.model.repository.PageRepository ;

@RestController
public class PageController {
  
  @Inject
  private PageRepository pageRepository ;
  
  @RequestMapping(value = "/admin/pages", method = RequestMethod.POST)
  public ResponseEntity<Void> createPage(@Valid @RequestBody Page page) {
	page = this.pageRepository.save(page) ;
	// Set the location header for the newly created resource
	final HttpHeaders responseHeaders = new HttpHeaders() ;
	final URI newPageUri =
	    ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(page.getId())
	        .toUri() ;
	responseHeaders.setLocation(newPageUri) ;
	
	return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED) ;
  }
  
  @RequestMapping(value = "/admin/pages/{pageId}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> deletePage(@PathVariable final Long pageId) {
	this.verifyPage(pageId) ;
	this.pageRepository.delete(pageId) ;
	return new ResponseEntity<>(HttpStatus.OK) ;
  }
  
  @RequestMapping(value = "/admin/pages", method = RequestMethod.GET)
  public ResponseEntity<Iterable<Page>> getAllpages(final Pageable pageable) {
	final Iterable<Page> allpages = this.pageRepository.findAll(pageable) ;
	return new ResponseEntity<>(allpages, HttpStatus.OK) ;
  }
  
  @RequestMapping(value = "/admin/pages/{pageId}", method = RequestMethod.GET)
  public ResponseEntity<?> getPage(@PathVariable final Long pageId) {
	this.verifyPage(pageId) ;
	final Page p = this.pageRepository.findOne(pageId) ;
	return new ResponseEntity<>(p, HttpStatus.OK) ;
  }
  
  @RequestMapping(value = "/admin/pages/{pageId}", method = RequestMethod.PUT)
  public ResponseEntity<Void> updatePage(@RequestBody final Page page,
	  @PathVariable final Long pageId) {
	this.verifyPage(pageId) ;
	this.pageRepository.save(page) ;
	return new ResponseEntity<>(HttpStatus.OK) ;
  }
  
  protected void verifyPage(final Long pageId) throws ResourceNotFoundException {
	final Page page = this.pageRepository.findOne(pageId) ;
	if (page == null) {
	  throw new ResourceNotFoundException("Page with id " + pageId + " not found") ;
	}
  }
  
}
