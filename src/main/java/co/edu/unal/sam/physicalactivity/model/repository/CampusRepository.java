package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.physicalactivity.model.domain.Campus;

public interface CampusRepository extends CrudRepository<Campus, Long> {

    @Query
    @Override
    public Iterable<Campus> findAll();
}
