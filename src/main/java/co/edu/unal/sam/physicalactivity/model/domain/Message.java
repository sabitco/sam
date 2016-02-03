package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "message")
public class Message extends Entity {

	@Column(name = "body", columnDefinition = "TEXT", nullable = false)
	@NotNull
	private String body;

	@Column(name = "description", columnDefinition = "TEXT", nullable = true)
	@Null
	private String description;

	@ManyToMany(mappedBy = "messages")
	private Set<RiskPlan> riskPlans = new HashSet<>(0);

	@Column(name = "tag", nullable = false, length = 300)
	@NotNull
	private String tag;

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

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
	 * @return the riskPlans
	 */
	public Set<RiskPlan> getRiskPlans() {
		return riskPlans;
	}

	/**
	 * @param riskPlans
	 *            the riskPlans to set
	 */
	public void setRiskPlans(Set<RiskPlan> riskPlans) {
		this.riskPlans = riskPlans;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag
	 *            the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

}