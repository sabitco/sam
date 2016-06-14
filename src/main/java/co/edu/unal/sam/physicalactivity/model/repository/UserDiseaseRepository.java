package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.aspect.model.enumerator.StateEnum;
import co.edu.unal.sam.physicalactivity.model.domain.UserDisease;
import co.edu.unal.sam.physicalactivity.model.dto.DiseaseDto;

public interface UserDiseaseRepository extends CrudRepository<UserDisease, Long> {

    @Query(name = "UserDisease.findDiseaseDtoByStateOrUser")
    Iterable<DiseaseDto> findDiseaseDtoByStateOrUser(@Param("state") StateEnum state,
            @Param("user") User user);

}
