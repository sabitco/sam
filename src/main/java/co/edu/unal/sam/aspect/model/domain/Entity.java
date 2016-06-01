package co.edu.unal.sam.aspect.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;

@MappedSuperclass
@JsonInclude(Include.NON_EMPTY)
public class Entity {

    @Column(name = "date_register", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateRegister;

    @Column(name = "date_update")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateUpdate;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    protected Long id;

    @NotNull
    @Column(name = "name", nullable = false, length = 300)
    protected String name;

    @NotNull
    @Column(name = "state_id", nullable = false)
    @Type(type = "co.edu.unal.sam.aspect.model.usertype.StateUserType")
    protected StateEnum state;

    public Entity() {
        this.state = StateEnum.ACTIVE;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Entity)) {
            return false;
        }
        final Entity other = (Entity) obj;
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StateEnum getState() {
        return state;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    @PrePersist
    protected void onPrePersist() {
        this.dateRegister = new Date();
    }

    @PreUpdate
    protected void onPreUpdate() {
        this.dateUpdate = new Date();
    }

}
