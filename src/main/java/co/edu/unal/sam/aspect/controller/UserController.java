package co.edu.unal.sam.aspect.controller;

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

import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.aspect.model.repository.UserRepository;

@RestController
public class UserController {

    @Inject
    private UserRepository userRepository;

    @RequestMapping(value = "/admin/users", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@Valid @RequestBody User user) {
        user = this.userRepository.save(user);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        responseHeaders.setLocation(newUserUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/users/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        this.verifyUser(userId);
        User p = this.userRepository.findOne(userId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getAllusers() {
        Iterable<User> allusers = this.userRepository.findAll();
        return new ResponseEntity<>(allusers, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/users/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@RequestBody User user, @PathVariable Long userId) {
        this.verifyUser(userId);
        this.userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/users/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        this.verifyUser(userId);
        this.userRepository.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyUser(Long userId) throws ResourceNotFoundException {
        User user = this.userRepository.findOne(userId);
        if (user == null) {
            throw new ResourceNotFoundException("User with id " + userId + " not found");
        }
    }

}
