package co.edu.unal.sam.physicalactivity.model.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.physicalactivity.model.domain.Bmi;

public interface BmiRepository extends CrudRepository<Bmi, Long> {

    Set<Bmi> findByUser(@Param("user") User user);
}
