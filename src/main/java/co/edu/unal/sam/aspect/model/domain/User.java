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

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;
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

	@Column(name = "height")
	private Integer height;

	@Column(name = "history")
	private Boolean history;
	
	@Column(name="PASSWORD")
    @NotEmpty
    @JsonIgnore
    private String password;

	@ManyToOne()
	@JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_role_user"))
	private Role role;

	@OneToMany(mappedBy = "user")
	private Set<SubGoal> subGoals = new HashSet<>(0);
	
	@Column(name = "type_user_id", nullable = false)
    @Type(type = "co.edu.unal.sam.aspect.model.usertype.TypeUserType")
    private TypeUserEnum typeuser;

	@Column(name = "use_condition")
	private Boolean useCondition;

	@Column(name = "user_name", unique = true, length = 300, nullable = false)
	@NotNull
	private String username;

	@Column(name = "weight")
	private Integer weight;

	/**
	 * @return the bmi
	 */
	public Integer getBmi() {
		return bmi;
	}

	/**
	 * @param bmi
	 *            the bmi to set
	 */
	public void setBmi(Integer bmi) {
		this.bmi = bmi;
	}

	/**
	 * @return the dateBirth
	 */
	public Date getDateBirth() {
		return dateBirth;
	}

	/**
	 * @param dateBirth
	 *            the dateBirth to set
	 */
	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	/**
	 * @return the dateIngress
	 */
	public Date getDateIngress() {
		return dateIngress;
	}

	/**
	 * @param dateIngress
	 *            the dateIngress to set
	 */
	public void setDateIngress(Date dateIngress) {
		this.dateIngress = dateIngress;
	}

	/**
	 * @return the dateInteraction
	 */
	public Date getDateInteraction() {
		return dateInteraction;
	}

	/**
	 * @param dateInteraction
	 *            the dateInteraction to set
	 */
	public void setDateInteraction(Date dateInteraction) {
		this.dateInteraction = dateInteraction;
	}

	/**
	 * @return the descriptionHistory
	 */
	public String getDescriptionHistory() {
		return descriptionHistory;
	}

	/**
	 * @param descriptionHistory
	 *            the descriptionHistory to set
	 */
	public void setDescriptionHistory(String descriptionHistory) {
		this.descriptionHistory = descriptionHistory;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * @return the history
	 */
	public Boolean getHistory() {
		return history;
	}

	/**
	 * @param history
	 *            the history to set
	 */
	public void setHistory(Boolean history) {
		this.history = history;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the typeuser
	 */
	public TypeUserEnum getTypeuser() {
		return typeuser;
	}

	/**
	 * @param typeuser
	 *            the typeuser to set
	 */
	public void setTypeuser(TypeUserEnum typeuser) {
		this.typeuser = typeuser;
	}

	/**
	 * @return the subGoals
	 */
	public Set<SubGoal> getSubGoals() {
		return subGoals;
	}

	/**
	 * @param subGoals
	 *            the subGoals to set
	 */
	public void setSubGoals(Set<SubGoal> subGoals) {
		this.subGoals = subGoals;
	}

	/**
	 * @return the useCondition
	 */
	public Boolean getUseCondition() {
		return useCondition;
	}

	/**
	 * @param useCondition
	 *            the useCondition to set
	 */
	public void setUseCondition(Boolean useCondition) {
		this.useCondition = useCondition;
	}

	/**
	 * @return the userName
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the weight
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
