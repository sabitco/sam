package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.physicalactivity.model.domain.ResponseHealth;

public interface ReponseHealthRepository extends
		CrudRepository<ResponseHealth, Long> {

}
