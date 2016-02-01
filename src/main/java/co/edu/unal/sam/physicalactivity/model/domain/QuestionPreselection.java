package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;

import org.hibernate.annotations.Type;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.physicalactivity.model.enumerator.TypeQuestionEnum;

@javax.persistence.Entity
@javax.persistence.Table(name = "question_preselection")
public class QuestionPreselection extends Entity {

    @Column(name = "description" )
    private String description;

    @Column(name = "type_question_id")
    @Type(type = "co.edu.unal.sam.physicalactivity.model.usertype.TypeQuestionUserType")
    private TypeQuestionEnum typeQuestion;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeQuestionEnum getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(TypeQuestionEnum typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

}
