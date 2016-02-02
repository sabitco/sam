package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "plan")
public class Plan extends Entity {

    @Column(name = "minute", nullable = false)
    @NotNull
    private Integer minute;

    @Column(name = "obese", nullable = false)
    @NotNull
    private Boolean obese;

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Boolean getObese() {
        return obese;
    }

    public void setObese(Boolean obese) {
        this.obese = obese;
    }

}
