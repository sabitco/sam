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

    @Column(name = "message_alert", nullable = false, length = 300)
    @NotNull
    private String messageAlert;

    @Column(name = "tag", nullable = false, length = 300)
    @NotNull
    private String tag;

    @ManyToOne()
    @JoinColumn(name = "question_health_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_tip_question_health") )
    @NotNull
    private QuestionHealth questionHealth;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessageAlert() {
        return messageAlert;
    }

    public void setMessageAlert(String messageAlert) {
        this.messageAlert = messageAlert;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public QuestionHealth getQuestionHealth() {
        return questionHealth;
    }

    public void setQuestionHealth(QuestionHealth questionHealth) {
        this.questionHealth = questionHealth;
    }

}
