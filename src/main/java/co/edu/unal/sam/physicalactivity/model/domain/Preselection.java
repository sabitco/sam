package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "preselection")
public class Preselection extends Entity {

	@Column(name = "result", nullable = true, length = 300)
	@Null
	private String result;

	@ManyToOne()
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull
	private User user;

	@ManyToOne()
	@JoinColumn(name = "risk_plan_id", nullable = false)
	@NotNull
	private RiskPlan riskPlan;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RiskPlan getRiskPlan() {
        return riskPlan;
    }

    public void setRiskPlan(RiskPlan riskPlan) {
        this.riskPlan = riskPlan;
    }
	
	
	
}