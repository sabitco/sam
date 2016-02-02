package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.physicalactivity.model.domain.*;

@javax.persistence.Entity
@javax.persistence.Table(name = "preselection")
public class Preselection extends Entity {

	@Column(name = "result", nullable = true, length = 300)
	@Null
	private String name;

	@ManyToOne()
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull
	private User user;

	@ManyToOne()
	@JoinColumn(name = "risk_plan_id", nullable = false)
	@NotNull
	private RiskPlan riskPlan;
}