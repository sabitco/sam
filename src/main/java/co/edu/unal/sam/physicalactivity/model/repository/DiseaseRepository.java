package co.edu.unal.sam.physicalactivity.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Disease;

public interface DiseaseRepository extends CrudRepository<Disease, Long> {

    List<Disease> findByState(StateEnum state);

}
