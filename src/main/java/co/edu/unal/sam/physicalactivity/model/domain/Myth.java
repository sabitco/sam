package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "alert")
public class Myth extends Entity {

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Myth() {}

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
