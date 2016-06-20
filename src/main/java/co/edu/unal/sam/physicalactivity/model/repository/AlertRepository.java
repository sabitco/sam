package co.edu.unal.sam.physicalactivity.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Alert;
import co.edu.unal.sam.physicalactivity.model.dto.AlertDto;

public interface AlertRepository extends CrudRepository<Alert, Long> {

    @Query(name = "Alert.findDtoAll")
    List<AlertDto> findDtoAll(@Param("state") StateEnum state);

}
