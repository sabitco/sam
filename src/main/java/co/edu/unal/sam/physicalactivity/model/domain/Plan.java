package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "plan")
public class Plan extends Entity {

	@Column(name = "minute", nullable = false)
	@NotNull
	private Integer minute;

	@Column(name = "obese", nullable = false)
	@NotNull
	private Boolean obese;
}