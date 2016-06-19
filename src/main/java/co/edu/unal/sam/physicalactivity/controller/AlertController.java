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
import co.edu.unal.sam.physicalactivity.model.domain.Alert;
import co.edu.unal.sam.physicalactivity.model.repository.AlertRepository;

@RestController
public class AlertController {

    @Inject
    private AlertRepository repository;

    @RequestMapping(value = "/admin/alerts", method = RequestMethod.POST)
    public ResponseEntity<Void> createAlert(@Valid @RequestBody Alert alert) {
        alert = this.repository.save(alert);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAlertUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(alert.getId()).toUri();
        responseHeaders.setLocation(newAlertUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/alerts/{alertId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAlert(@PathVariable Long alertId) {
        this.verify(alertId);
        Alert p = this.repository.findOne(alertId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/alerts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Alert>> getAllalerts() {
        Iterable<Alert> allalerts = this.repository.findAll();
        return new ResponseEntity<>(allalerts, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/alerts/{alertId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateAlert(@RequestBody Alert alert, @PathVariable Long alertId) {
        this.verify(alertId);
        this.repository.save(alert);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/alerts/{alertId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAlert(@PathVariable Long alertId) {
        this.verify(alertId);
        this.repository.delete(alertId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verify(Long alertId) throws ResourceNotFoundException {
        Alert alert = this.repository.findOne(alertId);
        if (alert == null) {
            throw new ResourceNotFoundException("Alert with id " + alertId + " not found");
        }
    }

}
