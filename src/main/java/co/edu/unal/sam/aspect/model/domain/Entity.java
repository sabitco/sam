package co.edu.unal.sam.aspect.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import co.edu.unal.sam.physicalactivity.model.enumerator.StateEnum;

@MappedSuperclass
public class Entity {

	@Id
	@GeneratedValue
	@NotNull
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "date_register", nullable = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRegister;

	@Column(name = "name", nullable = false, length = 300)
	@NotNull
	private String name;

	@Column(name = "state_id", nullable = false)
	@NotNull
	@Type(type = "co.edu.unal.sam.physicalactivity.model.usertype.StateUserType")
	private StateEnum state;

	public Entity() {
		this.dateRegister = new Date();
		this.state = StateEnum.ACTIVE;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Entity))
			return false;
		Entity other = (Entity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
