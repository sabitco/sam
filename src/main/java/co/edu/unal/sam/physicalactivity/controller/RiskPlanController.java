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

import co.edu.unal.sam.physicalactivity.model.domain.RiskPlan;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.RiskPlanRepository;

@RestController
public class RiskPlanController {

    @Inject
    private RiskPlanRepository riskPlanRepository;

    @RequestMapping(value = "/admin/riskPlans", method = RequestMethod.POST)
    public ResponseEntity<Void> createRiskPlan(@Valid @RequestBody RiskPlan riskPlan) {
        riskPlan = this.riskPlanRepository.save(riskPlan);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRiskPlanUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(riskPlan.getId()).toUri();
        responseHeaders.setLocation(newRiskPlanUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/riskPlans/{riskPlanId}", method = RequestMethod.GET)
    public ResponseEntity<?> getRiskPlan(@PathVariable Long riskPlanId) {
        this.verifyRiskPlan(riskPlanId);
        RiskPlan p = this.riskPlanRepository.findOne(riskPlanId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/riskPlans", method = RequestMethod.GET)
    public ResponseEntity<Iterable<RiskPlan>> getAllriskPlans() {
        Iterable<RiskPlan> allriskPlans = this.riskPlanRepository.findAll();
        return new ResponseEntity<>(allriskPlans, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/riskPlans/{riskPlanId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateRiskPlan(@RequestBody RiskPlan riskPlan, @PathVariable Long riskPlanId) {
        this.verifyRiskPlan(riskPlanId);
        this.riskPlanRepository.save(riskPlan);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/riskPlans/{riskPlanId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteRiskPlan(@PathVariable Long riskPlanId) {
        this.verifyRiskPlan(riskPlanId);
        this.riskPlanRepository.delete(riskPlanId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyRiskPlan(Long riskPlanId) throws ResourceNotFoundException {
        RiskPlan riskPlan = this.riskPlanRepository.findOne(riskPlanId);
        if (riskPlan == null) {
            throw new ResourceNotFoundException("RiskPlan with id " + riskPlanId + " not found");
        }
    }

}
