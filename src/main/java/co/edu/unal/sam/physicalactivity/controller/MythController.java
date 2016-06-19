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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.domain.Myth;
import co.edu.unal.sam.physicalactivity.model.repository.MythRepository;

public class MythController {

    @Inject
    private MythRepository repository;

    @RequestMapping(value = "/admin/myths", method = RequestMethod.POST)
    public ResponseEntity<Void> createMyth(@Valid @RequestBody Myth myth) {
        myth = this.repository.save(myth);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newMythUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(myth.getId()).toUri();
        responseHeaders.setLocation(newMythUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/myths/{mythId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMyth(@PathVariable Long mythId) {
        this.verify(mythId);
        Myth p = this.repository.findOne(mythId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/myths", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Myth>> getAllmyths() {
        Iterable<Myth> allmyths = this.repository.findAll();
        return new ResponseEntity<>(allmyths, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/myths/{mythId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateMyth(@RequestBody Myth myth, @PathVariable Long mythId) {
        this.verify(mythId);
        this.repository.save(myth);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/myths/{mythId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMyth(@PathVariable Long mythId) {
        this.verify(mythId);
        this.repository.delete(mythId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verify(Long mythId) throws ResourceNotFoundException {
        Myth myth = this.repository.findOne(mythId);
        if (myth == null) {
            throw new ResourceNotFoundException("Myth with id " + mythId + " not found");
        }
    }
}
