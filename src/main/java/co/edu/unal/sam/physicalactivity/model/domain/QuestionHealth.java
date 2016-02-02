package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "question_health")
public class QuestionHealth extends Entity {

    @Column(name = "description", columnDefinition = "TEXT", nullable = true)
    @Null
    private String description;

    @ManyToOne()
    @JoinColumn(name = "risk_plan_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_question_health_risk_plan") )
    @NotNull
    private RiskPlan riskPlan;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RiskPlan getRiskPlan() {
        return riskPlan;
    }

    public void setRiskPlan(RiskPlan riskPlan) {
        this.riskPlan = riskPlan;
    }

}
