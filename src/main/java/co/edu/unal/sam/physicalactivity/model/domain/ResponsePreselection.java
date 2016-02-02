package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
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
    @JoinColumn(name = "question_preselection_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_response_preselection_question_preselection") )
    @NotNull
    private QuestionPreselection questionPreselection;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPosition() {
        return position;
    }

    public void setPosition(Boolean position) {
        this.position = position;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public TypeQuestionEnum getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(TypeQuestionEnum typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public QuestionPreselection getQuestionPreselection() {
        return questionPreselection;
    }

    public void setQuestionPreselection(QuestionPreselection questionPreselection) {
        this.questionPreselection = questionPreselection;
    }

}
