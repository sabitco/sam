package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "advantage")
@NamedQueries({@NamedQuery(name = "Advantage.findDtoAll",
        query = "select new co.edu.unal.sam.physicalactivity.model.dto.AdvantageDto(a.id, a.description) "
                + "from Advantage a where a.state = :state"),})
public class Advantage extends Entity {

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Advantage() {}

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
