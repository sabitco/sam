package co.edu.unal.sam.aspect.model.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;
import co.edu.unal.sam.physicalactivity.model.domain.Faculty;
import co.edu.unal.sam.physicalactivity.model.domain.SubGoal;

@javax.persistence.Entity
@javax.persistence.Table(name = "user")
public class User extends Entity {

    @Column(name = "bmi")
    private Integer bmi;

    @Column(name = "date_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dateBirth;

    @Column(name = "date_ingress", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dateIngress;

    @Column(name = "date_interaction", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dateInteraction;

    @Column(name = "description_history", columnDefinition = "TEXT")
    private String descriptionHistory;

    @Column(name = "email", nullable = false, length = 300)
    @NotNull
    private String email;

    @ManyToOne()
    @JoinColumn(name = "faculty_id", foreignKey = @ForeignKey(name = "fk_user_faculty") )
    private Faculty faculty;

    @Column(name = "height")
    private Integer height;

    @Column(name = "history")
    private Boolean history;

    @Column(name = "identity_document", nullable = false, unique = true)
    @NotNull
    private String identityDocument;

    @Column(name = "password")
    @NotEmpty
    @JsonIgnoreProperties(allowSetters = true)
    private String password;

    @ManyToOne()
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_role_user") )
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<SubGoal> subGoals = new HashSet<>(0);

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

    @Column(name = "weight")
    private Integer weight;

    public User() {
        super();
        this.dateIngress = new Date();
        this.dateInteraction = new Date();
    }

    /**
     * @return the bmi
     */
    public Integer getBmi() {
        return this.bmi;
    }

    /**
     * @return the dateBirth
     */
    public Date getDateBirth() {
        return this.dateBirth;
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
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return the faculty
     */
    public final Faculty getFaculty() {
        return this.faculty;
    }

    /**
     * @return the height
     */
    public Integer getHeight() {
        return this.height;
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
    public final String getIdentityDocument() {
        return this.identityDocument;
    }

    /**
     * @return the password
     */
    public final String getPassword() {
        return this.password;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return this.role;
    }

    /**
     * @return the subGoals
     */
    public Set<SubGoal> getSubGoals() {
        return this.subGoals;
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
     * @return the weight
     */
    public Integer getWeight() {
        return this.weight;
    }

    /**
     * @param bmi the bmi to set
     */
    public void setBmi(final Integer bmi) {
        this.bmi = bmi;
    }

    /**
     * @param dateBirth the dateBirth to set
     */
    public void setDateBirth(final Date dateBirth) {
        this.dateBirth = dateBirth;
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
     * @param email the email to set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * @param faculty the faculty to set
     */
    public final void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(final Integer height) {
        this.height = height;
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
    public final void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    /**
     * @param password the password to set
     */
    public final void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param role the role to set
     */
    public void setRole(final Role role) {
        this.role = role;
    }

    /**
     * @param subGoals the subGoals to set
     */
    public void setSubGoals(final Set<SubGoal> subGoals) {
        this.subGoals = subGoals;
    }

    /**
     * @param surname the surname to set
     */
    public final void setSurname(String surname) {
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

    /**
     * @param weight w. the weight to set
     */
    public void setWeight(final Integer weight) {
        this.weight = weight;
    }

}
