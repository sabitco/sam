package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "subgoal")
public class SubGoal extends Entity {

    @Column(name = "comment", columnDefinition = "TEXT", nullable = true)
    @Null
    private String comment;

    @Column(name = "date_realization", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dateRealization;

    @Column(name = "minute", nullable = false)
    @NotNull
    private Integer minute;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_subgoal_user") )
    @NotNull
    private User user;

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the dateRealization
     */
    public Date getDateRealization() {
        return dateRealization;
    }

    /**
     * @param dateRealization the dateRealization to set
     */
    public void setDateRealization(Date dateRealization) {
        this.dateRealization = dateRealization;
    }

    /**
     * @return the minute
     */
    public Integer getMinute() {
        return minute;
    }

    /**
     * @param minute the minute to set
     */
    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

}
