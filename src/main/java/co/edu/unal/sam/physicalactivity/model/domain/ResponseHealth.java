package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.domain.User;

@javax.persistence.Entity
@javax.persistence.Table(name = "response_health")
public class ResponseHealth extends Entity {

	@Column(name = "position", nullable = false)
	@NotNull
	private Boolean position;

	@ManyToOne()
	@JoinColumn(name = "question_Health_id", nullable = false, foreignKey = @ForeignKey(name = "fk_response_health_question_health"))
	@NotNull
	private QuestionHealth questionHealth;

	@ManyToOne()
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull
	private User user;

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
	 * @return the questionHealth
	 */
	public QuestionHealth getQuestionHealth() {
		return questionHealth;
	}

	/**
	 * @param questionHealth
	 *            the questionHealth to set
	 */
	public void setQuestionHealth(QuestionHealth questionHealth) {
		this.questionHealth = questionHealth;
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

}
