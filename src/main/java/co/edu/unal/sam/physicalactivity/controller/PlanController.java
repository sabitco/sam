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

import co.edu.unal.sam.physicalactivity.model.domain.Plan;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.PlanRepository;

@RestController
public class PlanController {

    @Inject
    private PlanRepository planRepository;

    @RequestMapping(value = "/admin/plans", method = RequestMethod.POST)
    public ResponseEntity<Void> createPlan(@Valid @RequestBody Plan plan) {
        plan = this.planRepository.save(plan);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPlanUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(plan.getId()).toUri();
        responseHeaders.setLocation(newPlanUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/plans/{planId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPlan(@PathVariable Long planId) {
        this.verifyPlan(planId);
        Plan p = this.planRepository.findOne(planId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/plans", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Plan>> getAllplans() {
        Iterable<Plan> allplans = this.planRepository.findAll();
        return new ResponseEntity<>(allplans, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/plans/{planId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updatePlan(@RequestBody Plan plan, @PathVariable Long planId) {
        this.verifyPlan(planId);
        this.planRepository.save(plan);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/admin/plans/{planId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePlan(@PathVariable Long planId) {
        this.verifyPlan(planId);
        this.planRepository.delete(planId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyPlan(Long planId) throws ResourceNotFoundException {
        Plan plan = this.planRepository.findOne(planId);
        if (plan == null) {
            throw new ResourceNotFoundException("Plan with id " + planId + " not found");
        }
    }

}
