package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "alert")
@NamedQueries({@NamedQuery(name = "Alert.findDtoAll",
        query = "select new co.edu.unal.sam.physicalactivity.model.dto.AlertDto(a.id, a.description) "
                + "from Alert a where a.state = :state"),})
public class Alert extends Entity {

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Alert() {}

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
