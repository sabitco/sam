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

	@Column(name = "tag", nullable = false, length = 300)
	@NotNull
	private String tag;

	@ManyToMany(mappedBy = "messages")
	private Set<RiskPlan> riskPlans = new HashSet<>(0);

}
