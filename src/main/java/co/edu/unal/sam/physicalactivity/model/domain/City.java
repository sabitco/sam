package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "city")
@NamedQueries({
        @NamedQuery(name = "City.findByStateClass",
                query = "select new Faculty(f.id, f.name) from City f where f.stateClass = :stateClass order by f.name"),
        @NamedQuery(name = "City.findByStateClassAndState",
                query = "select new City(f.id, f.name) from City f where f.stateClass = :stateClass and f.state = :state  order by f.name"),})
public class City extends Entity {

    @ManyToOne()
    @JoinColumn(name = "state_class_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_city_state"))
    @NotNull
    private State stateClass;

    public City() {}

    public City(final Long id, final String name) {
        this();
        this.id = id;
        this.name = name;
    }

    /**
     * @return the stateClass
     */
    public State getStateClass() {
        return stateClass;
    }

    /**
     * @param stateClass the stateClass to set
     */
    public void setStateClass(State stateClass) {
        this.stateClass = stateClass;
    }

}
