package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "faculty")
public class Faculty extends Entity {

    @ManyToOne()
    @JoinColumn(name = "campus_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_faculty_campus") )
    @NotNull
    private Campus campus;

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
