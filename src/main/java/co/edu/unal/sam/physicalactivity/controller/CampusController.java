package co.edu.unal.sam.physicalactivity.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.domain.Campus;
import co.edu.unal.sam.physicalactivity.model.domain.Faculty;
import co.edu.unal.sam.physicalactivity.model.repository.CampusRepository;
import co.edu.unal.sam.physicalactivity.model.repository.FacultyRepository;

@RestController
public class CampusController {

    @Inject
    private CampusRepository campusRepository;

    @Inject
    private FacultyRepository facultyRepository;

    @RequestMapping(value = "/campus", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Campus>> getCampus() {
        Iterable<Campus> all = this.campusRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/campus/{campusId}/faculties", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Faculty>> getFaculties(@PathVariable Long campusId) {
        Campus campus = this.verify(campusId);
        Iterable<Faculty> all = this.facultyRepository.findByCampus(campus);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    protected Campus verify(Long id) throws ResourceNotFoundException {
        Campus campus = this.campusRepository.findOne(id);
        if (campus == null) {
            throw new ResourceNotFoundException("Campus with id " + id + " not found");
        }
        return campus;
    }

}
