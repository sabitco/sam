package co.edu.unal.sam.physicalactivity.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Event;
import co.edu.unal.sam.physicalactivity.model.dto.EventDto;

public interface EventRepository extends CrudRepository<Event, Long> {

    @Query(name = "Event.findDtoAll")
    List<EventDto> findDtoAll(@Param("state") StateEnum state);

}
