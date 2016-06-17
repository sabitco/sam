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

    public Entity() {}

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
        if (this.state == null) {
            this.state = StateEnum.ACTIVE;
        }
    }

    @PreUpdate
    protected void onPreUpdate() {
        this.dateUpdate = new Date();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateRegister == null) ? 0 : dateRegister.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Entity))
            return false;
        Entity other = (Entity) obj;
        if (dateRegister == null) {
            if (other.dateRegister != null)
                return false;
        } else if (!dateRegister.equals(other.dateRegister))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
