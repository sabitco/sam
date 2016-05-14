package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "campus")
@NamedQueries({
        @NamedQuery(name = "Campus.findAll", query = "select c from Campus c order by c.name"),
        @NamedQuery(name = "Campus.findByState",
                query = "select new Campus(c.id, c.name) from Campus c where c.state = :state order by c.name"),})
public class Campus extends Entity {

    @JsonIgnore
    @OneToMany(mappedBy = "campus")
    private Set<Faculty> faculties;

    public Campus() {
        super();
        this.faculties = new HashSet<>(0);
    }

    public Campus(final Long id, final String name) {
        this();
        this.id = id;
        this.name = name;
    }

    /**
     * @return the faculties
     */
    public Set<Faculty> getFaculties() {
        return this.faculties;
    }

    /**
     * @param faculties the faculties to set
     */
    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

}
