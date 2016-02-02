package co.edu.unal.sam.physicalactivity.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unal.sam.physicalactivity.model.domain.UserRiskPlan;

public interface UserRiskPlanRepository extends
		CrudRepository<UserRiskPlan, Long> {

}
