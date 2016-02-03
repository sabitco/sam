package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "activity")
public class Activity extends Entity {

	@Column(name = "date_start", nullable = false)
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dateStart;

	@Column(name = "date_end", nullable = false)
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dateEnd;

	@Column(name = "description", columnDefinition = "TEXT", nullable = true)
	@Null
	private String description;

	@Column(name = "friday", nullable = false)
	@NotNull
	private Boolean friday;

	@Column(name = "monday", nullable = false)
	@NotNull
	private Boolean monday;

	@Column(name = "place", nullable = false, length = 300)
	@NotNull
	private String place;

	@Column(name = "saturday", nullable = false)
	@NotNull
	private Boolean saturday;

	@Column(name = "sunday", nullable = false)
	@NotNull
	private Boolean sunday;

	@Column(name = "tuesday", nullable = false)
	@NotNull
	private Boolean tuesday;

	@Column(name = "thursday", nullable = false)
	@NotNull
	private Boolean thursday;

	@Column(name = "webnesday", nullable = false)
	@NotNull
	private Boolean webnesday;

	/**
	 * @return the dateStart
	 */
	public Date getDateStart() {
		return dateStart;
	}

	/**
	 * @param dateStart
	 *            the dateStart to set
	 */
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	/**
	 * @return the dateEnd
	 */
	public Date getDateEnd() {
		return dateEnd;
	}

	/**
	 * @param dateEnd
	 *            the dateEnd to set
	 */
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the friday
	 */
	public Boolean getFriday() {
		return friday;
	}

	/**
	 * @param friday
	 *            the friday to set
	 */
	public void setFriday(Boolean friday) {
		this.friday = friday;
	}

	/**
	 * @return the monday
	 */
	public Boolean getMonday() {
		return monday;
	}

	/**
	 * @param monday
	 *            the monday to set
	 */
	public void setMonday(Boolean monday) {
		this.monday = monday;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the saturday
	 */
	public Boolean getSaturday() {
		return saturday;
	}

	/**
	 * @param saturday
	 *            the saturday to set
	 */
	public void setSaturday(Boolean saturday) {
		this.saturday = saturday;
	}

	/**
	 * @return the sunday
	 */
	public Boolean getSunday() {
		return sunday;
	}

	/**
	 * @param sunday
	 *            the sunday to set
	 */
	public void setSunday(Boolean sunday) {
		this.sunday = sunday;
	}

	/**
	 * @return the tuesday
	 */
	public Boolean getTuesday() {
		return tuesday;
	}

	/**
	 * @param tuesday
	 *            the tuesday to set
	 */
	public void setTuesday(Boolean tuesday) {
		this.tuesday = tuesday;
	}

	/**
	 * @return the thursday
	 */
	public Boolean getThursday() {
		return thursday;
	}

	/**
	 * @param thursday
	 *            the thursday to set
	 */
	public void setThursday(Boolean thursday) {
		this.thursday = thursday;
	}

	/**
	 * @return the webnesday
	 */
	public Boolean getWebnesday() {
		return webnesday;
	}

	/**
	 * @param webnesday
	 *            the webnesday to set
	 */
	public void setWebnesday(Boolean webnesday) {
		this.webnesday = webnesday;
	}

}
