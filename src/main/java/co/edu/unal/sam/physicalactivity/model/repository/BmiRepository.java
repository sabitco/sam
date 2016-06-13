package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.physicalactivity.model.domain.Bmi;

public interface BmiRepository extends CrudRepository<Bmi, Long> {

}
