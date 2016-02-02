package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "risk_plan")
public class RiskPlan extends Entity {

    @Column(name = "description")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "risk_id", nullable = false)
    @NotNull
    private Risk risk;

    @ManyToOne()
    @JoinColumn(name = "plan_id", nullable = false)
    @NotNull
    private Plan plan;

    @ManyToMany()
    @JoinTable(name = "message_risk_plan",
            joinColumns = {@JoinColumn(name = "risk_plan_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_message_risk_plan_risk_plan") )},
            inverseJoinColumns = {@JoinColumn(name = "message_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_message_risk_plan_message") )})
    private Set<Message> messages = new HashSet<>(0);

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

}
