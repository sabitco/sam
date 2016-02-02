package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "user_risk_plan")
public class UserRiskPlan extends Entity {

    @Column(name = "date_start_risk", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dateStartRisk;

    @Column(name = "weight", nullable = false)
    @NotNull
    private Integer weight;

    @ManyToOne()
    @JoinColumn(name = "risk_plan_id", nullable = false)
    @NotNull
    private RiskPlan riskPlan;

    @ManyToOne()
    @JoinColumn(name = "preselection_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_risk_plan_preselection") )
    @NotNull
    private Preselection preselection;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_risk_plan_user") )
    @NotNull
    private User user;

    public Date getDateStartRisk() {
        return dateStartRisk;
    }

    public void setDateStartRisk(Date dateStartRisk) {
        this.dateStartRisk = dateStartRisk;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public RiskPlan getRiskPlan() {
        return riskPlan;
    }

    public void setRiskPlan(RiskPlan riskPlan) {
        this.riskPlan = riskPlan;
    }

    public Preselection getPreselection() {
        return preselection;
    }

    public void setPreselection(Preselection preselection) {
        this.preselection = preselection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
