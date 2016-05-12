package co.edu.unal.sam.physicalactivity.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unal.sam.physicalactivity.model.domain.Campus;
import co.edu.unal.sam.physicalactivity.model.repository.CampusRepository;

@RestController
public class CampusController {

    @Inject
    private CampusRepository repository;

    @RequestMapping(value = "/campus", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Campus>> getCampus() {
        Iterable<Campus> all = this.repository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

}
