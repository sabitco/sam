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

import co.edu.unal.sam.aspect.model.domain.Role;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.aspect.model.repository.RoleRepository;

@RestController
public class RoleController {

    @Inject
    private RoleRepository roleRepository;

    @RequestMapping(value = "/admin/roles", method = RequestMethod.POST)
    public ResponseEntity<Void> createRole(@Valid @RequestBody Role role) {
        role = this.roleRepository.save(role);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRoleUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(role.getId()).toUri();
        responseHeaders.setLocation(newRoleUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/roles/{roleId}", method = RequestMethod.GET)
    public ResponseEntity<?> getRole(@PathVariable Long roleId) {
        this.verifyRole(roleId);
        Role p = this.roleRepository.findOne(roleId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/roles", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Role>> getAllroles() {
        Iterable<Role> allroles = this.roleRepository.findAll();
        return new ResponseEntity<>(allroles, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/roles/{roleId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateRole(@RequestBody Role role, @PathVariable Long roleId) {
        this.verifyRole(roleId);
        this.roleRepository.save(role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/roles/{roleId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteRole(@PathVariable Long roleId) {
        this.verifyRole(roleId);
        this.roleRepository.delete(roleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyRole(Long roleId) throws ResourceNotFoundException {
        Role role = this.roleRepository.findOne(roleId);
        if (role == null) {
            throw new ResourceNotFoundException("Role with id " + roleId + " not found");
        }
    }

}
