package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.physicalactivity.model.domain.ResponseHealth;

public interface ResponseHealthRepository extends
		CrudRepository<ResponseHealth, Long> {

}