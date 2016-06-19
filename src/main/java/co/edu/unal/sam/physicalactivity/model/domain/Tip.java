package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "tip")
@NamedQueries({@NamedQuery(name = "Tip.findDtoAll",
        query = "select new co.edu.unal.sam.physicalactivity.model.dto.TipDto(t.id, t.description) "
                + "from Tip t where t.state = :state"),})
public class Tip extends Entity {

    @Column(name = "description", columnDefinition = "TEXT", nullable = true)
    private String description;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
