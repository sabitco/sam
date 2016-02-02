package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.Type;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.physicalactivity.model.enumerator.StateEnum;

@javax.persistence.Entity
@javax.persistence.Table(name = "user")
public class User extends Entity {

	@Column(name = "bmi", nullable = false)
	@NotNull
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

	@Column(name = "description_history", columnDefinition = "TEXT", nullable = true)
	@Null
	private String descriptionHistory;

	@Column(name = "email", nullable = false, length = 300)
	@NotNull
	private String email;

	@Column(name = "height", nullable = false)
	@NotNull
	private Integer height;

	@Column(name = "history", nullable = true)
	@Null
	private Boolean history;

	@Column(name = "type_user_id", nullable = false)
	@NotNull
	@Type(type = "co.edu.unal.sam.aspect.model.usertype.TypeUserType")
	private StateEnum typeuser;

	@Column(name = "use_condition", nullable = false)
	@NotNull
	private Boolean useCondition;

	@Column(name = "user_name", nullable = false, unique = true, length = 300)
	@NotNull
	private String userName;

	@Column(name = "weight", nullable = false)
	@NotNull
	private Integer weight;

	@OneToMany(mappedBy = "user")
	private Set<SubGoal> subGoals = new HashSet<>(0);

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

	/**
	 * @return the typeuser
	 */
	public StateEnum getTypeuser() {
		return typeuser;
	}

	/**
	 * @param typeuser
	 *            the typeuser to set
	 */
	public void setTypeuser(StateEnum typeuser) {
		this.typeuser = typeuser;
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
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	/**
	 * @return the subgoals
	 */
	public Set<SubGoal> getSubGoals() {
		return subGoals;
	}

	/**
	 * @param subgoals
	 *            the subgoals to set
	 */
	public void setSubgoals(Set<SubGoal> subGoals) {
		this.subGoals = subGoals;
	}

}
