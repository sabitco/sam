package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Campus;

public interface CampusRepository extends CrudRepository<Campus, Long> {

    @Query
    @Override
    public Iterable<Campus> findAll();

    @Query
    public Iterable<Campus> findByState(@Param("state") StateEnum state);
}
