package co.edu.unal.sam.physicalactivity.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Advantage;
import co.edu.unal.sam.physicalactivity.model.dto.AdvantageDto;

public interface AdvantageRepository extends CrudRepository<Advantage, Long> {

    @Query(name = "Advantage.findDtoAll")
    List<AdvantageDto> findDtoAll(@Param("state") StateEnum state);

}
