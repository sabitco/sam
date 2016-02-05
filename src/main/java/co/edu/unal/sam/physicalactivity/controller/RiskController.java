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

import co.edu.unal.sam.physicalactivity.model.domain.Risk;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.RiskRepository;

@RestController
public class RiskController {

    @Inject
    private RiskRepository riskRepository;

    @RequestMapping(value = "/admin/risks", method = RequestMethod.POST)
    public ResponseEntity<Void> createRisk(@Valid @RequestBody Risk risk) {
        risk = this.riskRepository.save(risk);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRiskUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(risk.getId()).toUri();
        responseHeaders.setLocation(newRiskUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/risks/{riskId}", method = RequestMethod.GET)
    public ResponseEntity<?> getRisk(@PathVariable Long riskId) {
        this.verifyRisk(riskId);
        Risk p = this.riskRepository.findOne(riskId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/risks", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Risk>> getAllrisks() {
        Iterable<Risk> allrisks = this.riskRepository.findAll();
        return new ResponseEntity<>(allrisks, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/risks/{riskId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateRisk(@RequestBody Risk risk, @PathVariable Long riskId) {
        this.verifyRisk(riskId);
        this.riskRepository.save(risk);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/risks/{riskId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteRisk(@PathVariable Long riskId) {
        this.verifyRisk(riskId);
        this.riskRepository.delete(riskId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyRisk(Long riskId) throws ResourceNotFoundException {
        Risk risk = this.riskRepository.findOne(riskId);
        if (risk == null) {
            throw new ResourceNotFoundException("Risk with id " + riskId + " not found");
        }
    }

}
