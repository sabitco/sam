package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "state")
@NamedQueries({@NamedQuery(name = "State.findAll", query = "select c from State c order by c.name"),
        @NamedQuery(name = "State.findByState",
                query = "select new State(c.id, c.name) from State c where c.state = :state order by c.name"),})
public class State extends Entity {

    @JsonIgnore
    @OneToMany(mappedBy = "state")
    private Set<City> cities;

    public State() {
        super();
        this.cities = new HashSet<>(0);
    }

    public State(final Long id, final String name) {
        this();
        this.id = id;
        this.name = name;
    }

    /**
     * @return the cities
     */
    public Set<City> getCities() {
        return cities;
    }

    /**
     * @param cities the cities to set
     */
    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

}
