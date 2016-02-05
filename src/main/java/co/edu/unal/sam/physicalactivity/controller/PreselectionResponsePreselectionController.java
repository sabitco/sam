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

import co.edu.unal.sam.physicalactivity.model.domain.PreselectionResponsePreselection;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.PreselectionResponsePreselectionRepository;

@RestController
public class PreselectionResponsePreselectionController {

    @Inject
    private PreselectionResponsePreselectionRepository preselectionResponsePreselectionRepository;

    @RequestMapping(value = "/admin/preselectionResponsePreselections", method = RequestMethod.POST)
    public ResponseEntity<Void> createPreselectionResponsePreselection(@Valid @RequestBody PreselectionResponsePreselection preselectionResponsePreselection) {
        preselectionResponsePreselection = this.preselectionResponsePreselectionRepository.save(preselectionResponsePreselection);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPreselectionResponsePreselectionUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(preselectionResponsePreselection.getId()).toUri();
        responseHeaders.setLocation(newPreselectionResponsePreselectionUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/preselectionResponsePreselections/{preselectionResponsePreselectionId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPreselectionResponsePreselection(@PathVariable Long preselectionResponsePreselectionId) {
        this.verifyPreselectionResponsePreselection(preselectionResponsePreselectionId);
        PreselectionResponsePreselection p = this.preselectionResponsePreselectionRepository.findOne(preselectionResponsePreselectionId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/preselectionResponsePreselections", method = RequestMethod.GET)
    public ResponseEntity<Iterable<PreselectionResponsePreselection>> getAllpreselectionResponsePreselections() {
        Iterable<PreselectionResponsePreselection> allpreselectionResponsePreselections = this.preselectionResponsePreselectionRepository.findAll();
        return new ResponseEntity<>(allpreselectionResponsePreselections, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/preselectionResponsePreselections/{preselectionResponsePreselectionId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updatePreselectionResponsePreselection(@RequestBody PreselectionResponsePreselection preselectionResponsePreselection, @PathVariable Long preselectionResponsePreselectionId) {
        this.verifyPreselectionResponsePreselection(preselectionResponsePreselectionId);
        this.preselectionResponsePreselectionRepository.save(preselectionResponsePreselection);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/preselectionResponsePreselections/{preselectionResponsePreselectionId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePreselectionResponsePreselection(@PathVariable Long preselectionResponsePreselectionId) {
        this.verifyPreselectionResponsePreselection(preselectionResponsePreselectionId);
        this.preselectionResponsePreselectionRepository.delete(preselectionResponsePreselectionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyPreselectionResponsePreselection(Long preselectionResponsePreselectionId) throws ResourceNotFoundException {
        PreselectionResponsePreselection preselectionResponsePreselection = this.preselectionResponsePreselectionRepository.findOne(preselectionResponsePreselectionId);
        if (preselectionResponsePreselection == null) {
            throw new ResourceNotFoundException("PreselectionResponsePreselection with id " + preselectionResponsePreselectionId + " not found");
        }
    }

}
