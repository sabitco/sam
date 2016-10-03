package co.edu.unal.sam.physicalactivity.model.service;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.State;
import co.edu.unal.sam.physicalactivity.model.repository.StateRepository;

@Component
public class StateService {

    @Inject
    private StateRepository repository;

    public Iterable<State> getStates(final StateEnum state) {
        Iterable<State> all = new ArrayList<>();
        if (state == null) {
            all = this.repository.findAll();
        } else {
            all = this.repository.findByState(state);
        }
        return all;
    }

    public State verify(Long id) {
        State state = this.repository.findOne(id);
        if (state == null) {
            throw new ResourceNotFoundException("Campus with id " + id + " not found");
        }
        return state;
    }

}
