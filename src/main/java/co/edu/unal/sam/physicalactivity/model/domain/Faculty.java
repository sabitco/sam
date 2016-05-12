package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "faculty")
@NamedQueries({@NamedQuery(name = "Faculty.findByCampus",
        query = "select new co.edu.unal.sam.physicalactivity.model.domain.Faculty(f.id, f.name) from Faculty f where f.campus = :campus order by f.name"),})
public class Faculty extends Entity {

    @ManyToOne()
    @JoinColumn(name = "campus_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_faculty_campus") )
    @NotNull
    private Campus campus;

    public Faculty() {

    }

    public Faculty(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the campus
     */
    public final Campus getCampus() {
        return this.campus;
    }

    /**
     * @param campus the campus to set
     */
    public final void setCampus(Campus campus) {
        this.campus = campus;
    }

}
