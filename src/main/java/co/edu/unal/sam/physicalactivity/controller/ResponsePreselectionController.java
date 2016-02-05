package co.edu.unal.sam.physicalactivity.controller;

import java.net.URI;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.edu.unal.sam.physicalactivity.model.domain.ResponsePreselection;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.ResponsePreselectionRepository;

@RestController
public class ResponsePreselectionController {

    @Inject
    private ResponsePreselectionRepository responsePreselectionRepository;

    @RequestMapping(value = "/admin/responsePreselections", method = RequestMethod.POST)
    public ResponseEntity<Void> createResponsePreselection(@Valid @RequestBody ResponsePreselection responsePreselection) {
        responsePreselection = this.responsePreselectionRepository.save(responsePreselection);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newResponsePreselectionUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(responsePreselection.getId()).toUri();
        responseHeaders.setLocation(newResponsePreselectionUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/responsePreselections/{responsePreselectionId}", method = RequestMethod.GET)
    public ResponseEntity<?> getResponsePreselection(@PathVariable Long responsePreselectionId) {
        this.verifyResponsePreselection(responsePreselectionId);
        ResponsePreselection p = this.responsePreselectionRepository.findOne(responsePreselectionId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/responsePreselections", method = RequestMethod.GET)
    public ResponseEntity<Iterable<ResponsePreselection>> getAllresponsePreselections() {
        Iterable<ResponsePreselection> allresponsePreselections = this.responsePreselectionRepository.findAll();
        return new ResponseEntity<>(allresponsePreselections, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/responsePreselections/{responsePreselectionId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateResponsePreselection(@RequestBody ResponsePreselection responsePreselection, @PathVariable Long responsePreselectionId) {
        this.verifyResponsePreselection(responsePreselectionId);
        this.responsePreselectionRepository.save(responsePreselection);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/responsePreselections/{responsePreselectionId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteResponsePreselection(@PathVariable Long responsePreselectionId) {
        this.verifyResponsePreselection(responsePreselectionId);
        this.responsePreselectionRepository.delete(responsePreselectionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyResponsePreselection(Long responsePreselectionId) throws ResourceNotFoundException {
        ResponsePreselection responsePreselection = this.responsePreselectionRepository.findOne(responsePreselectionId);
        if (responsePreselection == null) {
            throw new ResourceNotFoundException("ResponsePreselection with id " + responsePreselectionId + " not found");
        }
    }

}

