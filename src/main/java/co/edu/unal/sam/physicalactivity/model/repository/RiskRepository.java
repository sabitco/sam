package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.physicalactivity.model.domain.Risk;

public interface RiskRepository extends CrudRepository<Risk, Long> {

}
