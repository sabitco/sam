package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.physicalactivity.model.domain.RiskPlan;


@javax.persistence.Entity
@javax.persistence.Table(name = "preselection")
public class Preselection extends Entity {

	@Column(name = "result", nullable = true, length = 300)
	@Null
	private String result;

	@ManyToOne()
	@JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_preselection_user"))
	@NotNull
	private User user;

	@ManyToOne()
	@JoinColumn(name = "risk_plan_id", nullable = false, foreignKey = @ForeignKey(name = "fk_preselection_risk_plan"))
	@NotNull
	private RiskPlan riskPlan;

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
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

}
