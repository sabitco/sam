package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "risk_plan")
public class RiskPlan extends Entity {
	
    @Column(name = "description" )
    private String description;
    
	@ManyToOne()
	@JoinColumn(name = "risk_id", nullable = false)
	@NotNull
	private Risk risk;

	@ManyToOne()
	@JoinColumn(name = "plan_id", nullable = false)
	@NotNull
	private Plan plan;

	@ManyToMany()
	@JoinTable(name = "message_risk_plan", joinColumns = { @JoinColumn(name = "risk_plan_id", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "message_id", nullable = false) })
	private Set<Message> messages = new HashSet<>(0);
}