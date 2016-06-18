package co.edu.unal.sam.aspect.model.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Bmi;
import co.edu.unal.sam.physicalactivity.model.domain.Faculty;
import co.edu.unal.sam.physicalactivity.model.domain.Goal;
import co.edu.unal.sam.physicalactivity.model.domain.PhysicalActivity;
import co.edu.unal.sam.physicalactivity.model.domain.UserDisease;

@javax.persistence.Entity
@javax.persistence.Table(name = "user")
@NamedQueries({@NamedQuery(name = "User.findUserDtoByUsername",
        query = "select new co.edu.unal.sam.physicalactivity.model.dto.UserDto("
                + "u.dateBirth, u.dateExpireClasification, u.dateRegister, u.dateUpdate, u.email, b.height, "
                + "u.id, u.identityDocument, u.name, u.state, u.typeuser, u.username, b.weight"
                + ") from User u left join u.bmis b where u.username = :username order by b.dateRegister"),})
public class User extends Entity {

    @OneToMany(mappedBy = "user")
    private Set<Bmi> bmis;

    @NotNull
    @Column(name = "date_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateBirth;

    @Column(name = "date_expire_clasification")
    @Temporal(TemporalType.DATE)
    private Date dateExpireClasification;

    @NotNull
    @Column(name = "date_ingress")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateIngress;

    @NotNull
    @Column(name = "date_interaction", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInteraction;

    @Column(name = "description_history", columnDefinition = "TEXT")
    private String descriptionHistory;

    @OneToMany(mappedBy = "user")
    private Set<UserDisease> diseases;

    @NotNull
    @Column(name = "email", nullable = false, length = 300)
    private String email;

    @ManyToOne()
    @JoinColumn(name = "faculty_id", foreignKey = @ForeignKey(name = "fk_user_faculty"))
    private Faculty faculty;

    @ManyToMany(mappedBy = "users")
    private Set<Goal> goals = new HashSet<>(0);

    @Column(name = "history")
    private Boolean history;

    @NotNull
    @Column(name = "identity_document", nullable = false, unique = true)
    private String identityDocument;

    @Column(name = "password")
    @NotEmpty
    @JsonIgnoreProperties(allowSetters = true)
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<PhysicalActivity> physicalActivities;

    @ManyToOne()
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_user_role"))
    private Role role;

    @Column(name = "surname", nullable = false)
    @NotNull
    private String surname;

    @Column(name = "type_user_id", nullable = true)
    @Type(type = "co.edu.unal.sam.aspect.model.usertype.TypeUserType")
    @NotNull
    private TypeUserEnum typeuser;

    @Column(name = "use_condition")
    private Boolean useCondition;

    @Column(name = "user_name", unique = true, length = 300, nullable = false)
    @NotNull
    private String username;

    public User() {
        super();
        this.bmis = new HashSet<>(0);
        this.dateIngress = new Date();
        this.dateInteraction = new Date();
        this.physicalActivities = new HashSet<>(0);
        this.diseases = new HashSet<>(0);
    }

    /**
     * @return the bmis
     */
    public Set<Bmi> getBmis() {
        return this.bmis;
    }

    /**
     * @return the dateBirth
     */
    public Date getDateBirth() {
        return this.dateBirth;
    }

    /**
     * @return the dateExpireClasification
     */
    public Date getDateExpireClasification() {
        return this.dateExpireClasification;
    }

    /**
     * @return the dateIngress
     */
    public Date getDateIngress() {
        return this.dateIngress;
    }

    /**
     * @return the dateInteraction
     */
    public Date getDateInteraction() {
        return this.dateInteraction;
    }

    /**
     * @return the descriptionHistory
     */
    public String getDescriptionHistory() {
        return this.descriptionHistory;
    }

    /**
     * @return the diseases
     */
    public Set<UserDisease> getDiseases() {
        return this.diseases;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return the faculty
     */
    public Faculty getFaculty() {
        return this.faculty;
    }

    /**
     * @return the goals
     */
    public Set<Goal> getGoals() {
        return this.goals;
    }

    /**
     * @return the history
     */
    public Boolean getHistory() {
        return this.history;
    }

    /**
     * @return the identityDocument
     */
    public String getIdentityDocument() {
        return this.identityDocument;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @return the physicalActivities
     */
    public Set<PhysicalActivity> getPhysicalActivities() {
        return this.physicalActivities;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return this.role;
    }

    public String getSurname() {
        return this.surname;
    }

    /**
     * @return the typeuser
     */
    public TypeUserEnum getTypeuser() {
        return this.typeuser;
    }

    /**
     * @return the useCondition
     */
    public Boolean getUseCondition() {
        return this.useCondition;
    }

    /**
     * @return the userName
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @param bmis the bmis to set
     */
    public void setBmis(Set<Bmi> bmis) {
        this.bmis = bmis;
    }

    /**
     * @param dateBirth the dateBirth to set
     */
    public void setDateBirth(final Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    /**
     * @param dateExpireClasification the dateExpireClasification to set
     */
    public void setDateExpireClasification(final Date dateExpireClasification) {
        this.dateExpireClasification = dateExpireClasification;
    }

    /**
     * @param dateIngress the dateIngress to set
     */
    public void setDateIngress(final Date dateIngress) {
        this.dateIngress = dateIngress;
    }

    /**
     * @param dateInteraction the dateInteraction to set
     */
    public void setDateInteraction(final Date dateInteraction) {
        this.dateInteraction = dateInteraction;
    }

    /**
     * @param descriptionHistory the descriptionHistory to set
     */
    public void setDescriptionHistory(final String descriptionHistory) {
        this.descriptionHistory = descriptionHistory;
    }

    /**
     * @param diseases the diseases to set
     */
    public void setDiseases(Set<UserDisease> diseases) {
        this.diseases = diseases;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * @param faculty the faculty to set
     */
    public final void setFaculty(final Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(Set<Goal> goals) {
        this.goals = goals;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(final Boolean history) {
        this.history = history;
    }

    /**
     * @param identityDocument the identityDocument to set
     */
    public final void setIdentityDocument(final String identityDocument) {
        this.identityDocument = identityDocument;
    }

    /**
     * @param password the password to set
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @param physicalActivities the physicalActivities to set
     */
    public void setPhysicalActivities(final Set<PhysicalActivity> physicalActivities) {
        this.physicalActivities = physicalActivities;
    }

    /**
     * @param role the role to set
     */
    public void setRole(final Role role) {
        this.role = role;
    }

    /**
     * @param surname the surname to set
     */
    public final void setSurname(final String surname) {
        this.surname = surname;
    }

    /**
     * @param typeuser the typeuser to set
     */
    public void setTypeuser(final TypeUserEnum typeuser) {
        this.typeuser = typeuser;
    }

    /**
     * @param useCondition the useCondition to set
     */
    public void setUseCondition(final Boolean useCondition) {
        this.useCondition = useCondition;
    }

    /**
     * @param username d. the userName to set
     */
    public void setUsername(final String username) {
        this.username = username;
    }

}
