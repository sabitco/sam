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

import co.edu.unal.sam.physicalactivity.model.domain.UserRiskPlan;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.UserRiskPlanRepository;

@RestController
public class UserRiskPlanController {

    @Inject
    private UserRiskPlanRepository userRiskPlanRepository;

    @RequestMapping(value = "/admin/userRiskPlans", method = RequestMethod.POST)
    public ResponseEntity<Void> createUserRiskPlan(@Valid @RequestBody UserRiskPlan userRiskPlan) {
        userRiskPlan = this.userRiskPlanRepository.save(userRiskPlan);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserRiskPlanUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(userRiskPlan.getId()).toUri();
        responseHeaders.setLocation(newUserRiskPlanUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/userRiskPlans/{userRiskPlanId}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserRiskPlan(@PathVariable Long userRiskPlanId) {
        this.verifyUserRiskPlan(userRiskPlanId);
        UserRiskPlan p = this.userRiskPlanRepository.findOne(userRiskPlanId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/userRiskPlans", method = RequestMethod.GET)
    public ResponseEntity<Iterable<UserRiskPlan>> getAlluserRiskPlans() {
        Iterable<UserRiskPlan> alluserRiskPlans = this.userRiskPlanRepository.findAll();
        return new ResponseEntity<>(alluserRiskPlans, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/userRiskPlans/{userRiskPlanId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUserRiskPlan(@RequestBody UserRiskPlan userRiskPlan, @PathVariable Long userRiskPlanId) {
        this.verifyUserRiskPlan(userRiskPlanId);
        this.userRiskPlanRepository.save(userRiskPlan);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/userRiskPlans/{userRiskPlanId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUserRiskPlan(@PathVariable Long userRiskPlanId) {
        this.verifyUserRiskPlan(userRiskPlanId);
        this.userRiskPlanRepository.delete(userRiskPlanId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyUserRiskPlan(Long userRiskPlanId) throws ResourceNotFoundException {
        UserRiskPlan userRiskPlan = this.userRiskPlanRepository.findOne(userRiskPlanId);
        if (userRiskPlan == null) {
            throw new ResourceNotFoundException("UserRiskPlan with id " + userRiskPlanId + " not found");
        }
    }

}
