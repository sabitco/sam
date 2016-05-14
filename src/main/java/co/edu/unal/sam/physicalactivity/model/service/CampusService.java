package co.edu.unal.sam.physicalactivity.model.service;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Campus;
import co.edu.unal.sam.physicalactivity.model.repository.CampusRepository;

/**
 * 
 * @author Andrés Mise Olivera
 *
 */
@Component
public class CampusService {

    @Inject
    private CampusRepository repository;

    public Iterable<Campus> getCampus(final StateEnum state) {
        Iterable<Campus> all = new ArrayList<>();
        if (state == null) {
            all = this.repository.findAll();
        } else {
            all = this.repository.findByState(state);
        }
        return all;
    }

    public Campus verify(Long id) {
        Campus campus = this.repository.findOne(id);
        if (campus == null) {
            throw new ResourceNotFoundException("Campus with id " + id + " not found");
        }
        return campus;
    }

}
