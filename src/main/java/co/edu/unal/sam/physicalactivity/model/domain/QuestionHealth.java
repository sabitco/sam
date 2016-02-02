package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "question_health")
public class QuestionHealth extends Entity {

	@Column(name = "description", columnDefinition = "TEXT", nullable = true)
	@Null
	private String description;

	@ManyToOne()
	@JoinColumn(name = "risk_plan_id", nullable = false)
	@NotNull
	private RiskPlan riskPlan;

}
