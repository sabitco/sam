package co.edu.unal.sam.physicalactivity.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Myth;
import co.edu.unal.sam.physicalactivity.model.dto.MythDto;

public interface MythRepository extends CrudRepository<Myth, Long> {

    @Query(name = "Myth.findDtoAll")
    List<MythDto> findDtoAll(@Param("state") StateEnum state);
}
