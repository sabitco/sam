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

import co.edu.unal.sam.physicalactivity.model.domain.ResponseHealth;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.ResponseHealthRepository;

@RestController
public class ResponseHealthController {

    @Inject
    private ResponseHealthRepository responseHealthRepository;

    @RequestMapping(value = "/admin/responseHealths", method = RequestMethod.POST)
    public ResponseEntity<Void> createResponseHealth(@Valid @RequestBody ResponseHealth responseHealth) {
        responseHealth = this.responseHealthRepository.save(responseHealth);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newResponseHealthUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(responseHealth.getId()).toUri();
        responseHeaders.setLocation(newResponseHealthUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/responseHealths/{responseHealthId}", method = RequestMethod.GET)
    public ResponseEntity<?> getResponseHealth(@PathVariable Long responseHealthId) {
        this.verifyResponseHealth(responseHealthId);
        ResponseHealth p = this.responseHealthRepository.findOne(responseHealthId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/responseHealths", method = RequestMethod.GET)
    public ResponseEntity<Iterable<ResponseHealth>> getAllresponseHealths() {
        Iterable<ResponseHealth> allresponseHealths = this.responseHealthRepository.findAll();
        return new ResponseEntity<>(allresponseHealths, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/responseHealths/{responseHealthId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateResponseHealth(@RequestBody ResponseHealth responseHealth, @PathVariable Long responseHealthId) {
        this.verifyResponseHealth(responseHealthId);
        this.responseHealthRepository.save(responseHealth);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/responseHealths/{responseHealthId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteResponseHealth(@PathVariable Long responseHealthId) {
        this.verifyResponseHealth(responseHealthId);
        this.responseHealthRepository.delete(responseHealthId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyResponseHealth(Long responseHealthId) throws ResourceNotFoundException {
        ResponseHealth responseHealth = this.responseHealthRepository.findOne(responseHealthId);
        if (responseHealth == null) {
            throw new ResourceNotFoundException("ResponseHealth with id " + responseHealthId + " not found");
        }
    }

}

