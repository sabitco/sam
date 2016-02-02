package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.Type;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.physicalactivity.model.enumerator.TypeQuestionEnum;

@javax.persistence.Entity
@javax.persistence.Table(name = "response_preselection")
public class ResponsePreselection extends Entity {

	@Column(name = "description", columnDefinition = "TEXT", nullable = true)
	@Null
	private String description;

	@Column(name = "position", nullable = true)
	@Null
	private Boolean position;

	@Column(name = "score", nullable = false)
	@NotNull
	private Integer score;

	@Column(name = "type_question_id")
	@Type(type = "co.edu.unal.sam.physicalactivity.model.usertype.TypeQuestionUserType")
	private TypeQuestionEnum typeQuestion;

	@ManyToOne()
	@JoinColumn(name = "question_preselection_id", nullable = false)
	@NotNull
	private QuestionPreselection questionPreselection;

}
