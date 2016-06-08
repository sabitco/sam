package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.domain.User;

@javax.persistence.Entity
@javax.persistence.Table(name = "user_disease")
@NamedQueries({@NamedQuery(name = "UserDisease.findDiseaseDtoByStateOrUser",
        query = "select new co.edu.unal.sam.physicalactivity.model.dto.DiseaseDto(d.id, d.name "
                + ", case when u.id is not null then true else false end) "
                + "from Disease d left join d.users u where d.state = :state or u.user = :user"),})
public class UserDisease extends Entity {

    @ManyToOne()
    @JoinColumn(name = "disease_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_disease_disease") )
    @NotNull
    private Disease disease;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_disease_user") )
    @NotNull
    private User user;

    /**
     * @return the disease
     */
    public Disease getDisease() {
        return this.disease;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return this.user;
    }

    /**
     * @param disease the disease to set
     */
    public void setDisease(Disease disease) {
        super.name = disease.getName();
        this.disease = disease;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }



}
