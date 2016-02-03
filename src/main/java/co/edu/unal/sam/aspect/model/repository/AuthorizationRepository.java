package co.edu.unal.sam.aspect.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.aspect.model.domain.Authorization;

public interface AuthorizationRepository extends
		CrudRepository<Authorization, Long> {

}
	