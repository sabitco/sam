package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "myth")
@NamedQueries({@NamedQuery(name = "Myth.findDtoAll",
        query = "select new co.edu.unal.sam.physicalactivity.model.dto.MythDto(m.id, m.description) "
                + "from Myth m where m.state = :state"),})
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
