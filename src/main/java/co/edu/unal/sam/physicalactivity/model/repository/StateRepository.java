package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.State;

public interface StateRepository extends CrudRepository<State, Long> {

    @Query
    @Override
    public Iterable<State> findAll();

    @Query
    public Iterable<State> findByState(@Param("state") StateEnum state);

}
