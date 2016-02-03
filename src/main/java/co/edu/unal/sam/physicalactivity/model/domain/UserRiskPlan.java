package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.domain.User;

@javax.persistence.Entity
@javax.persistence.Table(name = "user_risk_plan")
public class UserRiskPlan extends Entity {

	@Column(name = "date_start_risk", nullable = false)
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dateStartRisk;

	@ManyToOne()
	@JoinColumn(name = "preselection_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_risk_plan_preselection"))
	@NotNull
	private Preselection preselection;

	@ManyToOne()
	@JoinColumn(name = "risk_plan_id", nullable = false)
	@NotNull
	private RiskPlan riskPlan;

	@ManyToOne()
	@JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_risk_plan_user"))
	@NotNull
	private User user;

	@Column(name = "weight", nullable = false)
	@NotNull
	private Integer weight;

	/**
	 * @return the dateStartRisk
	 */
	public Date getDateStartRisk() {
		return dateStartRisk;
	}

	/**
	 * @param dateStartRisk
	 *            the dateStartRisk to set
	 */
	public void setDateStartRisk(Date dateStartRisk) {
		this.dateStartRisk = dateStartRisk;
	}

	/**
	 * @return the preselection
	 */
	public Preselection getPreselection() {
		return preselection;
	}

	/**
	 * @param preselection
	 *            the preselection to set
	 */
	public void setPreselection(Preselection preselection) {
		this.preselection = preselection;
	}

	/**
	 * @return the riskPlan
	 */
	public RiskPlan getRiskPlan() {
		return riskPlan;
	}

	/**
	 * @param riskPlan
	 *            the riskPlan to set
	 */
	public void setRiskPlan(RiskPlan riskPlan) {
		this.riskPlan = riskPlan;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the weight
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
