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

import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.domain.Advantage;
import co.edu.unal.sam.physicalactivity.model.repository.AdvantageRepository;

@RestController
public class AdvantageController {

    @Inject
    private AdvantageRepository repository;

    @RequestMapping(value = "/admin/advantages", method = RequestMethod.POST)
    public ResponseEntity<Void> createAdvantage(@Valid @RequestBody Advantage advantage) {
        advantage = this.repository.save(advantage);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAdvantageUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(advantage.getId()).toUri();
        responseHeaders.setLocation(newAdvantageUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/advantages/{advantageId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAdvantage(@PathVariable Long advantageId) {
        this.verify(advantageId);
        Advantage p = this.repository.findOne(advantageId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/advantages", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Advantage>> getAlladvantages() {
        Iterable<Advantage> alladvantages = this.repository.findAll();
        return new ResponseEntity<>(alladvantages, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/advantages/{advantageId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateAdvantage(@RequestBody Advantage advantage,
            @PathVariable Long advantageId) {
        this.verify(advantageId);
        this.repository.save(advantage);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/advantages/{advantageId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAdvantage(@PathVariable Long advantageId) {
        this.verify(advantageId);
        this.repository.delete(advantageId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verify(Long advantageId) throws ResourceNotFoundException {
        Advantage advantage = this.repository.findOne(advantageId);
        if (advantage == null) {
            throw new ResourceNotFoundException("Advantage with id " + advantageId + " not found");
        }
    }

}
