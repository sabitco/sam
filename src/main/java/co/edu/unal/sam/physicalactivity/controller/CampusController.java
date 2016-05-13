package co.edu.unal.sam.physicalactivity.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Campus;
import co.edu.unal.sam.physicalactivity.model.domain.Faculty;
import co.edu.unal.sam.physicalactivity.model.service.CampusService;
import co.edu.unal.sam.physicalactivity.model.service.FacultyService;

@RestController
public class CampusController {

    @Inject
    private CampusService campusService;

    @Inject
    private FacultyService facultyService;

    @RequestMapping(value = "/campus", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Campus>> getCampus(
            @RequestParam(name = "state", required = false) StateEnum state) {
        Iterable<Campus> all = this.campusService.getCampus(state);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/campus/{campusId}/faculties", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Faculty>> getFaculties(@PathVariable Long campusId,
            @RequestParam(name = "state", required = false) StateEnum state) {
        Campus campus = this.campusService.verify(campusId);
        Iterable<Faculty> all = this.facultyService.getFaculties(campus, state);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

}
