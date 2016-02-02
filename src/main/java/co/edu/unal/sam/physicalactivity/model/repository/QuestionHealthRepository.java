package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.physicalactivity.model.domain.QuestionHealth;

public interface QuestionHealthRepository extends
		CrudRepository<QuestionHealth, Long> {

}