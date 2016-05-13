package co.edu.unal.sam.physicalactivity.model.service;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Campus;
import co.edu.unal.sam.physicalactivity.model.domain.Faculty;
import co.edu.unal.sam.physicalactivity.model.repository.FacultyRepository;

/**
 * 
 * @author Andrés Mise Olivera
 *
 */
@Component
public class FacultyService {

    @Inject
    private FacultyRepository repository;

    public Iterable<Faculty> getFaculties(final Campus campus, final StateEnum state) {
        Iterable<Faculty> all = new ArrayList<>();
        if (state == null) {
            all = this.repository.findByCampus(campus);
        } else {
            all = this.repository.findByCampusAndState(campus, state);
        }
        return all;
    }

}
