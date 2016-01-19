package co.edu.unal.sam.controller;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.edu.unal.sam.domain.User;

@RestController
public class UserController {

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        // TODO create method

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        responseHeaders.setLocation(newUserUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

}
