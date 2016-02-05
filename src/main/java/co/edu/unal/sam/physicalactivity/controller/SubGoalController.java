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

import co.edu.unal.sam.physicalactivity.model.domain.SubGoal;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.SubGoalRepository;

@RestController
public class SubGoalController {

    @Inject
    private SubGoalRepository subGoalRepository;

    @RequestMapping(value = "/admin/subGoals", method = RequestMethod.POST)
    public ResponseEntity<Void> createSubGoal(@Valid @RequestBody SubGoal subGoal) {
        subGoal = this.subGoalRepository.save(subGoal);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newSubGoalUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(subGoal.getId()).toUri();
        responseHeaders.setLocation(newSubGoalUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/subGoals/{subGoalId}", method = RequestMethod.GET)
    public ResponseEntity<?> getSubGoal(@PathVariable Long subGoalId) {
        this.verifySubGoal(subGoalId);
        SubGoal p = this.subGoalRepository.findOne(subGoalId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/subGoals", method = RequestMethod.GET)
    public ResponseEntity<Iterable<SubGoal>> getAllsubGoals() {
        Iterable<SubGoal> allsubGoals = this.subGoalRepository.findAll();
        return new ResponseEntity<>(allsubGoals, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/subGoals/{subGoalId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateSubGoal(@RequestBody SubGoal subGoal, @PathVariable Long subGoalId) {
        this.verifySubGoal(subGoalId);
        this.subGoalRepository.save(subGoal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/admin/subGoals/{subGoalId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSubGoal(@PathVariable Long subGoalId) {
        this.verifySubGoal(subGoalId);
        this.subGoalRepository.delete(subGoalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifySubGoal(Long subGoalId) throws ResourceNotFoundException {
        SubGoal subGoal = this.subGoalRepository.findOne(subGoalId);
        if (subGoal == null) {
            throw new ResourceNotFoundException("SubGoal with id " + subGoalId + " not found");
        }
    }

}
