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

import co.edu.unal.sam.physicalactivity.model.domain.Tip;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.TipRepository;

@RestController
public class TipController {

    @Inject
    private TipRepository tipRepository;

    @RequestMapping(value = "/admin/tips", method = RequestMethod.POST)
    public ResponseEntity<Void> createTip(@Valid @RequestBody Tip tip) {
        tip = this.tipRepository.save(tip);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newTipUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(tip.getId()).toUri();
        responseHeaders.setLocation(newTipUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/tips/{tipId}", method = RequestMethod.GET)
    public ResponseEntity<?> getTip(@PathVariable Long tipId) {
        this.verifyTip(tipId);
        Tip p = this.tipRepository.findOne(tipId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/tips", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Tip>> getAlltips() {
        Iterable<Tip> alltips = this.tipRepository.findAll();
        return new ResponseEntity<>(alltips, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/tips/{tipId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateTip(@RequestBody Tip tip, @PathVariable Long tipId) {
        this.verifyTip(tipId);
        this.tipRepository.save(tip);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/tips/{tipId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTip(@PathVariable Long tipId) {
        this.verifyTip(tipId);
        this.tipRepository.delete(tipId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyTip(Long tipId) throws ResourceNotFoundException {
        Tip tip = this.tipRepository.findOne(tipId);
        if (tip == null) {
            throw new ResourceNotFoundException("Tip with id " + tipId + " not found");
        }
    }

}

