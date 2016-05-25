package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.physicalactivity.model.enumerator.TypeActivityEnum;

@javax.persistence.Entity
@javax.persistence.Table(name = "physical_activity")
public class PhysicalActivity extends Entity {

    /**
     * Nùmero de dias que practica deporte por semana
     */
    @NotNull
    @Column(name = "number_days", nullable = false)
    private Integer numberDays;

    /**
     * Número de horas que practica por día
     */
    @NotNull
    @Column(name = "number_hours", nullable = false)
    private Integer numberHours;

    @Column(name = "type_activity_id", nullable = false)
    @Type(type = "co.edu.unal.sam.physicalactivity.model.usertype.TypeActivityType")
    private TypeActivityEnum typeActivity;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_physical_activity_user") )
    private User user;

    public Integer getNumberDays() {
        return this.numberDays;
    }

    public Integer getNumberHours() {
        return this.numberHours;
    }

    public TypeActivityEnum getTypeActivity() {
        return this.typeActivity;
    }

    public User getUser() {
        return this.user;
    }

    public void setNumberDays(Integer numberDays) {
        this.numberDays = numberDays;
    }

    public void setNumberHours(Integer numberHours) {
        this.numberHours = numberHours;
    }

    public void setTypeActivity(TypeActivityEnum typeActivity) {
        this.typeActivity = typeActivity;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
