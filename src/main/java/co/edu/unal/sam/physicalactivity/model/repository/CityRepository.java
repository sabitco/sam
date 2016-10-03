package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unal.sam.physicalactivity.model.domain.City;
import co.edu.unal.sam.physicalactivity.model.domain.State;

public interface CityRepository extends CrudRepository<City, Long> {

    @Query
    Iterable<City> findByStateClass(@Param("stateClass") State state);

    // @Query
    // Iterable<City> findByStateClassAndStateEnum(@Param("stateClass") State state,
    // @Param("state") StateEnum stateEnum);

}
