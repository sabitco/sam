package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "campus")
public class Campus extends Entity {

    @OneToMany(mappedBy = "campus")
    @JsonIgnore
    private Set<Faculty> faculties;

    public Campus() {
        super();
        this.faculties = new HashSet<>(0);
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
