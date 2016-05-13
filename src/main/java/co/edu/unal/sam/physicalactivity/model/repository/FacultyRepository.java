package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Campus;
import co.edu.unal.sam.physicalactivity.model.domain.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty, Long> {

    @Query
    Iterable<Faculty> findByCampus(@Param("campus") Campus campus);

    @Query
    Iterable<Faculty> findByCampusAndState(@Param("campus") Campus campus,
            @Param("state") StateEnum state);

}
