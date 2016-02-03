package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
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

	@ManyToOne()
	@JoinColumn(name = "question_health_id", nullable = false, foreignKey = @ForeignKey(name = "fk_tip_question_health"))
	@NotNull
	private QuestionHealth questionHealth;

	@Column(name = "message_alert", nullable = false, length = 300)
	@NotNull
	private String messageAlert;

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
	 * @return the messageAlert
	 */
	public String getMessageAlert() {
		return messageAlert;
	}

	/**
	 * @param messageAlert
	 *            the messageAlert to set
	 */
	public void setMessageAlert(String messageAlert) {
		this.messageAlert = messageAlert;
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
