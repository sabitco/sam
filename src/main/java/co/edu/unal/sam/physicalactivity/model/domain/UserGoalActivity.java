package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.domain.User;

@javax.persistence.Entity
@javax.persistence.Table(name = "user_risk_plan")
public class UserGoalActivity extends Entity {

    @ManyToOne()
    @JoinColumn(name = "activity_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_goal_activity_activity"))
    private Activity activity;

    /**
     * Nùmero de dias que practica deporte por semana
     */
    @Column(name = "days")
    private Integer days;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "goal_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_goal_activity_goal"))
    private Goal goal;

    /**
     * Número de horas que practica por día
     */
    @Column(name = "minutes")
    private Integer minutes;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_goal_activity_user"))
    private User user;

    public UserGoalActivity() {}

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
     * @return the goal
     */
    public Goal getGoal() {
        return this.goal;
    }

    /**
     * @return the minutes
     */
    public Integer getMinutes() {
        return this.minutes;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return this.user;
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
     * @param goal the goal to set
     */
    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    /**
     * @param minutes the minutes to set
     */
    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

}
