package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.domain.User;

@javax.persistence.Entity
@javax.persistence.Table(name = "physical_activity")
@NamedQueries({
        @NamedQuery(name = "PhysicalActivity.findActivityDtoByStateOrUser",
                query = "select new co.edu.unal.sam.physicalactivity.model.dto.ActivityDto(a.id, a.name "
                        + ", case when pa.id is not null then true else false end) "
                        + "from Activity a left join a.physicalActivities pa where a.state = :state or pa.user = :user"),
        @NamedQuery(name = "PhysicalActivity.deleteByUser",
                query = "delete PhysicalActivity where user = :user"),})
public class PhysicalActivity extends Entity {

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "activity_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_physical_activity_activity"))
    private Activity activity;

    /**
     * Nùmero de dias que practica deporte por semana
     */
    @Column(name = "days")
    private Integer days;

    /**
     * Número de horas que practica por día
     */
    @Column(name = "minutes")
    private Integer minutes;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_physical_activity_user"))
    private User user;

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
