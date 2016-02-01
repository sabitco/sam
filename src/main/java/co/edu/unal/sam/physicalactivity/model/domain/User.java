package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "user")
public class User extends Entity {

    @Column(name = "birthdate", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date birthdate;
    
    @Column(name = "username", nullable = false, unique = true)
    @NotNull
    private String username;

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
