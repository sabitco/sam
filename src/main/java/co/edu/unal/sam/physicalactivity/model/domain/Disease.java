package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.Set;

import javax.persistence.OneToMany;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "disease")
public class Disease extends Entity {

    @OneToMany(mappedBy = "disease")
    private Set<UserDisease> users;

    /**
     * @return the users
     */
    public Set<UserDisease> getUsers() {
        return this.users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Set<UserDisease> users) {
        this.users = users;
    }

}
