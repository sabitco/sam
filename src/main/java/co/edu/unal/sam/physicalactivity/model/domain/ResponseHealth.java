package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "response_health")
public class ResponseHealth extends Entity {

	@Column(name = "position", nullable = false)
	@NotNull
	private Boolean position;

	@ManyToOne()
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull
	private User user;

	@ManyToOne()
	@JoinColumn(name = "question_Health_id", nullable = false)
	@NotNull
	private QuestionHealth questionHealth;

}
