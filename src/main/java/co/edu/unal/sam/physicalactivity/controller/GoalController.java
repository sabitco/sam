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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.domain.Goal;
import co.edu.unal.sam.physicalactivity.model.dto.GoalDto;
import co.edu.unal.sam.physicalactivity.model.dto.Statistic;
import co.edu.unal.sam.physicalactivity.model.repository.GoalRepository;
import co.edu.unal.sam.physicalactivity.model.service.GoalService;

@RestController
public class GoalController {

    @Inject
    private GoalRepository goalRepository;

    @Inject
    private GoalService service;

    @RequestMapping(value = "/admin/goals", method = RequestMethod.POST)
    public ResponseEntity<Void> createGoal(@Valid @RequestBody Goal goal) {
        goal = this.goalRepository.save(goal);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newGoalUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(goal.getId()).toUri();
        responseHeaders.setLocation(newGoalUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/goals/{goalId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteGoal(@PathVariable Long goalId) {
        this.verifyGoal(goalId);
        this.goalRepository.delete(goalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/goals/{goalId}", method = RequestMethod.GET)
    public ResponseEntity<?> getGoal(@PathVariable Long goalId) {
        this.verifyGoal(goalId);
        Goal p = this.goalRepository.findOne(goalId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/goals", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Goal>> getGoals() {
        Iterable<Goal> allgoals = this.goalRepository.findAll();
        return new ResponseEntity<>(allgoals, HttpStatus.OK);
    }

    @RequestMapping(value = "/goals/statistics/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Statistic>> getStatistics(@PathVariable Long userId) {
        Iterable<Statistic> statistics = this.service.getStatistics(userId);
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

    @RequestMapping(value = "/goals/users/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<GoalDto>> getGoals(@PathVariable Long userId,
            @RequestParam(name = "onlySelected", required = false) final Boolean onlySelected) {
        Iterable<GoalDto> goals = this.service.getGoals(userId, onlySelected);
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/goals/{goalId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateGoal(@RequestBody Goal goal, @PathVariable Long goalId) {
        this.verifyGoal(goalId);
        this.goalRepository.save(goal);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyGoal(Long goalId) throws ResourceNotFoundException {
        Goal goal = this.goalRepository.findOne(goalId);
        if (goal == null) {
            throw new ResourceNotFoundException("Goal with id " + goalId + " not found");
        }
    }

}
