package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "user_risk_plan")
public class UserRiskPlan extends Entity {

	@Column(name = "date_start_risk", nullable = false)
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dateStartRisk;

	@Column(name = "weight", nullable = false)
	@NotNull
	private Integer weight;

	@ManyToOne()
	@JoinColumn(name = "risk_plan_id", nullable = false)
	@NotNull
	private RiskPlan riskPlan;

	@ManyToOne()
	@JoinColumn(name = "preselection_id", nullable = false)
	@NotNull
	private Preselection preselection;

	@ManyToOne()
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull
	private User user;

}