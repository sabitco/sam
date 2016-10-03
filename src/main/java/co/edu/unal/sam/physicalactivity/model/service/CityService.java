package co.edu.unal.sam.physicalactivity.model.service;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.City;
import co.edu.unal.sam.physicalactivity.model.domain.State;
import co.edu.unal.sam.physicalactivity.model.repository.CityRepository;

/**
 * 
 * @author Andrés Mise Olivera
 *
 */
@Component
public class CityService {

    @Inject
    private CityRepository repository;

    public Iterable<City> getCities(final State entity, final StateEnum state) {
        Iterable<City> all = new ArrayList<>();
        // if (state == null) {
        all = this.repository.findByStateClass(entity);
        // } else {
        // all = this.repository.findByStateClassAndStateEnum(entity, state);
        // }
        return all;
    }

}
