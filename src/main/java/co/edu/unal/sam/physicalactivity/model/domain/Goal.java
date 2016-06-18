package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.domain.User;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_goal",
            joinColumns = {@JoinColumn(name = "goal_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_user_gols_user_id"))},
            inverseJoinColumns = {@JoinColumn(name = "user_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_user_goal_goal_id"))})
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

}
