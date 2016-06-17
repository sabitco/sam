package co.edu.unal.sam.physicalactivity.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum;

@JsonInclude(Include.NON_NULL)
public class Dto {

    protected Date dateRegister;
    protected Date dateUpdate;
    protected Long id;
    protected String name;
    protected StateEnum state;

    public Dto() {}

    public Dto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Dto(Date dateRegister, Date dateUpdate, Long id, String name, StateEnum state) {
        this(id, name);
        this.dateRegister = dateRegister;
        this.dateUpdate = dateUpdate;
        this.state = state;
    }

    /**
     * @return the dateRegister
     */
    public Date getDateRegister() {
        return this.dateRegister;
    }

    /**
     * @return the dateUpdate
     */
    public Date getDateUpdate() {
        return this.dateUpdate;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the state
     */
    public StateEnum getState() {
        return this.state;
    }

    /**
     * @param dateRegister the dateRegister to set
     */
    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    /**
     * @param dateUpdate the dateUpdate to set
     */
    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param state the state to set
     */
    public void setState(StateEnum state) {
        this.state = state;
    }

}
