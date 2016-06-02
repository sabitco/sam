package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.domain.User;
import co.edu.unal.sam.physicalactivity.model.enumerator.BmiCategoryEnum;

@javax.persistence.Entity
@javax.persistence.Table(name = "bmi")
public class Bmi extends Entity {

    @Column(name = "bmi")
    private Float bmi;

    @Transient
    private BmiCategoryEnum category;

    @Column(name = "height")
    private Float height;

    @ManyToOne()
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_bmi_user") )
    private User user;

    @Column(name = "weight")
    private Float weight;

    /**
     * @return the bmi
     */
    public Float getBmi() {
        return this.bmi;
    }

    /**
     * @return the category
     */
    public BmiCategoryEnum getCategory() {
        return this.category;
    }

    /**
     * @return the height
     */
    public Float getHeight() {
        return this.height;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return this.user;
    }

    /**
     * @return the weight
     */
    public Float getWeight() {
        return this.weight;
    }

    /**
     * @param bmi the bmi to set
     */
    public void setBmi(Float bmi) {
        this.bmi = bmi;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(BmiCategoryEnum category) {
        this.category = category;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Float height) {
        this.height = height;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Float weight) {
        this.weight = weight;
    }

}
