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

import co.edu.unal.sam.physicalactivity.model.domain.Preselection;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.PreselectionRepository;

@RestController
public class PreselectionController {

    @Inject
    private PreselectionRepository preselectionRepository;

    @RequestMapping(value = "/admin/preselections", method = RequestMethod.POST)
    public ResponseEntity<Void> createPreselection(@Valid @RequestBody Preselection preselection) {
        preselection = this.preselectionRepository.save(preselection);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPreselectionUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(preselection.getId()).toUri();
        responseHeaders.setLocation(newPreselectionUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/preselections/{preselectionId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPreselection(@PathVariable Long preselectionId) {
        this.verifyPreselection(preselectionId);
        Preselection p = this.preselectionRepository.findOne(preselectionId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/preselections", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Preselection>> getAllpreselections() {
        Iterable<Preselection> allpreselections = this.preselectionRepository.findAll();
        return new ResponseEntity<>(allpreselections, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/preselections/{preselectionId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updatePreselection(@RequestBody Preselection preselection, @PathVariable Long preselectionId) {
        this.verifyPreselection(preselectionId);
        this.preselectionRepository.save(preselection);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/preselections/{preselectionId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePreselection(@PathVariable Long preselectionId) {
        this.verifyPreselection(preselectionId);
        this.preselectionRepository.delete(preselectionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyPreselection(Long preselectionId) throws ResourceNotFoundException {
        Preselection preselection = this.preselectionRepository.findOne(preselectionId);
        if (preselection == null) {
            throw new ResourceNotFoundException("Preselection with id " + preselectionId + " not found");
        }
    }

}
