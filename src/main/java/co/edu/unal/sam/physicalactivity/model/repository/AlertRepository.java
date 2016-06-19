package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.physicalactivity.model.domain.Alert;

public interface AlertRepository extends CrudRepository<Alert, Long> {

}
