package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.physicalactivity.model.domain.UserGoalActivity;

public interface UserGoalActivityRepository extends CrudRepository<UserGoalActivity, Long> {

}
