package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.physicalactivity.model.enumerator.IntensityEnum;

@javax.persistence.Entity
@javax.persistence.Table(name = "activity")
public class Activity extends Entity {

    @Column(name = "intensity_id", nullable = false)
    @Type(type = "co.edu.unal.sam.physicalactivity.model.usertype.IntensityType")
    private IntensityEnum intensity;

    @OneToMany(mappedBy = "activity")
    private Set<PhysicalActivity> physicalActivities;

    /**
     * @return the intensity
     */
    public IntensityEnum getIntensity() {
        return this.intensity;
    }

    /**
     * @return the physicalActivities
     */
    public Set<PhysicalActivity> getPhysicalActivities() {
        return this.physicalActivities;
    }

    /**
     * @param intensity the intensity to set
     */
    public void setIntensity(IntensityEnum intensity) {
        this.intensity = intensity;
    }

    /**
     * @param physicalActivities the physicalActivities to set
     */
    public void setPhysicalActivities(Set<PhysicalActivity> physicalActivities) {
        this.physicalActivities = physicalActivities;
    }

}
