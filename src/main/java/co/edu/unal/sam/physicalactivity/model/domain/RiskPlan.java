package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "risk_plan")
public class RiskPlan extends Entity {

	@Column(name = "description")
	private String description;

	@ManyToMany()
	@JoinTable(name = "message_risk_plan", joinColumns = { @JoinColumn(name = "risk_plan_id", nullable = false, foreignKey = @ForeignKey(name = "fk_message_risk_plan_risk_plan")) }, inverseJoinColumns = { @JoinColumn(name = "message_id", nullable = false, foreignKey = @ForeignKey(name = "fk_message_risk_plan_message")) })
	private Set<Message> messages = new HashSet<>(0);

	@ManyToOne()
	@JoinColumn(name = "plan_id", nullable = false)
	@NotNull
	private Plan plan;

	@ManyToOne()
	@JoinColumn(name = "risk_id", nullable = false)
	@NotNull
	private Risk risk;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the messages
	 */
	public Set<Message> getMessages() {
		return messages;
	}

	/**
	 * @param messages
	 *            the messages to set
	 */
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	/**
	 * @return the plan
	 */
	public Plan getPlan() {
		return plan;
	}

	/**
	 * @param plan
	 *            the plan to set
	 */
	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	/**
	 * @return the risk
	 */
	public Risk getRisk() {
		return risk;
	}

	/**
	 * @param risk
	 *            the risk to set
	 */
	public void setRisk(Risk risk) {
		this.risk = risk;
	}

}
