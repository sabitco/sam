package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.PhysicalActivity;
import co.edu.unal.sam.physicalactivity.model.dto.ActivityDto;

public interface PhysicalActivityRepository extends CrudRepository<PhysicalActivity, Long> {

    @Modifying
    @Transactional
    @Query(name = "PhysicalActivity.deleteByUser")
    int deleteByUser(@Param("user") User user);

    @Query(name = "PhysicalActivity.findActivityDtoByStateOrUser")
    Iterable<ActivityDto> findActivityDtoByStateOrUser(@Param("state") StateEnum state,
            @Param("user") User user);

}
