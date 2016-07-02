package co.edu.unal.sam.physicalactivity.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.physicalactivity.model.domain.UserGoalActivity;

public interface UserGoalActivityRepository extends CrudRepository<UserGoalActivity, Long> {

    @Modifying
    @Transactional
    @Query(name = "UserGoalActivity.deleteByUserAndDateRegister")
    int deleteByUserAndDateRegister(@Param("user") User user,
            @Param("dateRegister") Date dateRegister);

    @Query(name = "UserGoalActivity.findByUserAndDateRegister")
    List<UserGoalActivity> findByUserAndDateRegister(@Param("user") User user,
            @Param("dateRegister") Date dateRegister);
}
