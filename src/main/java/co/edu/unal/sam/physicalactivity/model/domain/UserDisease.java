package co.edu.unal.sam.physicalactivity.model.domain;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.domain.User;

public class UserDisease extends Entity {

    private Disease disease;
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
        this.disease = disease;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }



}
