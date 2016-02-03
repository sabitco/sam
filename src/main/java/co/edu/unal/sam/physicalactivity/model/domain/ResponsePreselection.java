package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.Type;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.enumerator.TypeQuestionEnum;

@javax.persistence.Entity
@javax.persistence.Table(name = "response_preselection")
public class ResponsePreselection extends Entity {

	@Column(name = "description", columnDefinition = "TEXT", nullable = true)
	@Null
	private String description;

	@Column(name = "position", nullable = true)
	@Null
	private Boolean position;

	@ManyToOne()
	@JoinColumn(name = "question_preselection_id", nullable = false, foreignKey = @ForeignKey(name = "fk_response_preselection_question_preselection"))
	@NotNull
	private QuestionPreselection questionPreselection;

	@Column(name = "score", nullable = false)
	@NotNull
	private Integer score;

	@Column(name = "type_question_id")
	@Type(type = "co.edu.unal.sam.aspect.model.usertype.TypeQuestionUserType")
	private TypeQuestionEnum typeQuestion;

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
	 * @return the position
	 */
	public Boolean getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Boolean position) {
		this.position = position;
	}

	/**
	 * @return the questionPreselection
	 */
	public QuestionPreselection getQuestionPreselection() {
		return questionPreselection;
	}

	/**
	 * @param questionPreselection
	 *            the questionPreselection to set
	 */
	public void setQuestionPreselection(
			QuestionPreselection questionPreselection) {
		this.questionPreselection = questionPreselection;
	}

	/**
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * @return the typeQuestion
	 */
	public TypeQuestionEnum getTypeQuestion() {
		return typeQuestion;
	}

	/**
	 * @param typeQuestion
	 *            the typeQuestion to set
	 */
	public void setTypeQuestion(TypeQuestionEnum typeQuestion) {
		this.typeQuestion = typeQuestion;
	}

}
