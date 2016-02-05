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

import co.edu.unal.sam.aspect.model.domain.Authorization;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.aspect.model.repository.AuthorizationRepository;

@RestController
public class AuthorizationController {

    @Inject
    private AuthorizationRepository authorizationRepository;

    @RequestMapping(value = "/admin/authorizations", method = RequestMethod.POST)
    public ResponseEntity<Void> createAuthorization(@Valid @RequestBody Authorization authorization) {
        authorization = this.authorizationRepository.save(authorization);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAuthorizationUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(authorization.getId()).toUri();
        responseHeaders.setLocation(newAuthorizationUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/authorizations/{authorizationId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAuthorization(@PathVariable Long authorizationId) {
        this.verifyAuthorization(authorizationId);
        Authorization p = this.authorizationRepository.findOne(authorizationId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/authorizations", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Authorization>> getAllauthorizations() {
        Iterable<Authorization> allauthorizations = this.authorizationRepository.findAll();
        return new ResponseEntity<>(allauthorizations, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/authorizations/{authorizationId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateAuthorization(@RequestBody Authorization authorization, @PathVariable Long authorizationId) {
        this.verifyAuthorization(authorizationId);
        this.authorizationRepository.save(authorization);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/authorizations/{authorizationId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAuthorization(@PathVariable Long authorizationId) {
        this.verifyAuthorization(authorizationId);
        this.authorizationRepository.delete(authorizationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyAuthorization(Long authorizationId) throws ResourceNotFoundException {
        Authorization authorization = this.authorizationRepository.findOne(authorizationId);
        if (authorization == null) {
            throw new ResourceNotFoundException("Authorization with id " + authorizationId + " not found");
        }
    }

}
