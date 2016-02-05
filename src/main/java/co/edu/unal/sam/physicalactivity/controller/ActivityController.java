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

import co.edu.unal.sam.physicalactivity.model.domain.Activity;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.ActivityRepository;

@RestController
public class ActivityController {

    @Inject
    private ActivityRepository activityRepository;

    @RequestMapping(value = "/admin/activitys", method = RequestMethod.POST)
    public ResponseEntity<Void> createActivity(@Valid @RequestBody Activity activity) {
        activity = this.activityRepository.save(activity);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newActivityUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(activity.getId()).toUri();
        responseHeaders.setLocation(newActivityUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/activitys/{activityId}", method = RequestMethod.GET)
    public ResponseEntity<?> getActivity(@PathVariable Long activityId) {
        this.verifyActivity(activityId);
        Activity p = this.activityRepository.findOne(activityId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/activitys", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Activity>> getAllactivitys() {
        Iterable<Activity> allactivitys = this.activityRepository.findAll();
        return new ResponseEntity<>(allactivitys, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/activitys/{activityId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateActivity(@RequestBody Activity activity, @PathVariable Long activityId) {
        this.verifyActivity(activityId);
        this.activityRepository.save(activity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/activitys/{activityId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteActivity(@PathVariable Long activityId) {
        this.verifyActivity(activityId);
        this.activityRepository.delete(activityId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyActivity(Long activityId) throws ResourceNotFoundException {
        Activity activity = this.activityRepository.findOne(activityId);
        if (activity == null) {
            throw new ResourceNotFoundException("Activity with id " + activityId + " not found");
        }
    }

}
