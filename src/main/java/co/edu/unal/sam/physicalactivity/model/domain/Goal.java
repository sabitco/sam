package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.physicalactivity.model.enumerator.TermEnum;
import co.edu.unal.sam.physicalactivity.model.enumerator.TypeRiskEnum;

@javax.persistence.Entity
@javax.persistence.Table(name = "goal")
public class Goal extends Entity {

    @ManyToOne()
    @JoinColumn(name = "activity_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_goal_activity"))
    private Activity activity;

    /**
     * Nùmero de dias que practica deporte por semana
     */
    @Column(name = "days", nullable = false)
    private Integer days;

    /**
     * Número de horas que practica por día
     */
    @Column(name = "minutes", nullable = false)
    private Integer minutes;

    @Column(name = "risk_id", nullable = false)
    @Type(type = "co.edu.unal.sam.physicalactivity.model.usertype.TypeRiskType")
    private TypeRiskEnum risk;

    @Column(name = "term_id", nullable = false)
    @Type(type = "co.edu.unal.sam.physicalactivity.model.usertype.TermType")
    private TermEnum term;

    @ManyToMany(mappedBy = "goals", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>(0);

    /**
     * @return the activity
     */
    public Activity getActivity() {
        return this.activity;
    }

    /**
     * @return the days
     */
    public Integer getDays() {
        return this.days;
    }

    /**
     * @return the minutes
     */
    public Integer getMinutes() {
        return this.minutes;
    }

    /**
     * @return the risk
     */
    public TypeRiskEnum getRisk() {
        return this.risk;
    }

    /**
     * @return the term
     */
    public TermEnum getTerm() {
        return this.term;
    }

    /**
     * @return the users
     */
    public Set<User> getUsers() {
        return this.users;
    }

    /**
     * @param activity the activity to set
     */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    /**
     * @param days the days to set
     */
    public void setDays(Integer days) {
        this.days = days;
    }

    /**
     * @param minutes the minutes to set
     */
    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    /**
     * @param risk the risk to set
     */
    public void setRisk(TypeRiskEnum risk) {
        this.risk = risk;
    }

    /**
     * @param term the term to set
     */
    public void setTerm(TermEnum term) {
        this.term = term;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
