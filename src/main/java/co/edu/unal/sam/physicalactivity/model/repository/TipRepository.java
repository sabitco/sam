package co.edu.unal.sam.physicalactivity.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Tip;
import co.edu.unal.sam.physicalactivity.model.dto.TipDto;

public interface TipRepository extends CrudRepository<Tip, Long> {

    @Query(name = "Tip.findDtoAll")
    List<TipDto> findDtoAll(@Param("state") StateEnum state);
}
