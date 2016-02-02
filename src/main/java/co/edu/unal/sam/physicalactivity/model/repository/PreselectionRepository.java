package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.physicalactivity.model.domain.Preselection;

public interface PreselectionRepository extends
		CrudRepository<Preselection, Long> {

}