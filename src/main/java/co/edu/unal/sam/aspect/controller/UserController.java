package co.edu.unal.sam.aspect.controller;

import java.io.IOException;
import java.net.URI;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
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

import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.aspect.model.dto.response.Successful;
import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.aspect.model.repository.UserRepository;
import co.edu.unal.sam.physicalactivity.model.converter.UserConverter;
import co.edu.unal.sam.physicalactivity.model.dto.ActivityDto;
import co.edu.unal.sam.physicalactivity.model.dto.DiseaseDto;
import co.edu.unal.sam.physicalactivity.model.dto.UserDto;
import co.edu.unal.sam.physicalactivity.model.service.UserService;

@RestController
public class UserController {

    @Inject
    private UserConverter converter;

    @Inject
    private MessageSource messageSource;

    @Inject
    private UserRepository repository;

    @Inject
    private UserService service;

    @RequestMapping(value = "/users/classify", method = RequestMethod.PUT)
    public ResponseEntity<Void> classifyUser(@RequestBody UserDto user) {
        this.service.verify(user.getId());
        this.service.classifyUser(this.converter.convert(user));
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.POST)
    public ResponseEntity<Successful> createUser(@Valid @RequestBody UserDto dto) {
        User user = this.service.createUser(this.converter.convert(dto));
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        responseHeaders.setLocation(newUserUri);
        Successful success = new Successful();
        success.setMessage(this.messageSource.getMessage("user.created.successfully", null, null));
        success.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(success, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/users/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        this.service.verify(userId);
        this.repository.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/users/activities/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<ActivityDto>> getActivities(@PathVariable Long userId,
            @RequestParam(name = "state", required = false) final StateEnum state) {
        User user = this.service.verify(userId);
        Iterable<ActivityDto> activities = this.service.getActivities(user, state);
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getAllusers(Pageable pageable) {
        Iterable<User> allusers = this.repository.findAll(pageable);
        return new ResponseEntity<>(allusers, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/diseases/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<DiseaseDto>> getDiseases(@PathVariable Long userId,
            @RequestParam(name = "state", required = false) final StateEnum state) {
        User user = this.service.verify(userId);
        Iterable<DiseaseDto> diseases = this.service.getDiseases(user, state);
        return new ResponseEntity<>(diseases, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/users/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        this.service.verify(userId);
        User user = this.repository.findOne(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/preclassify", method = RequestMethod.PUT)
    public void preClassifyUser(@RequestBody UserDto user, final HttpServletResponse response)
            throws IOException {
        this.service.verify(user.getId());
        this.service.preClassifyUser(this.converter.convert(user));
        response.sendRedirect("physicalactivity/classificationdetail");
    }

    @RequestMapping(value = "/admin/users/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@RequestBody User user, @PathVariable Long userId) {
        this.service.verify(userId);
        this.repository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
