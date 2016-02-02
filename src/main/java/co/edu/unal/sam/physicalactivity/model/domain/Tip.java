package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "tip")
public class Tip extends Entity {

	@Column(name = "body", columnDefinition = "TEXT", nullable = false)
	@NotNull
	private String body;

	@Column(name = "description", columnDefinition = "TEXT", nullable = true)
	@Null
	private String description;

	@Column(name = "message_alert", nullable = false, length = 300)
	@NotNull
	private String messageAlert;

	@Column(name = "tag", nullable = false, length = 300)
	@NotNull
	private String tag;

	@ManyToOne()
	@JoinColumn(name = "question_health_id", nullable = false)
	@NotNull
	private QuestionHealth questionHealth;

}
