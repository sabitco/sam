package co.edu.unal.sam.aspect.model.domain ;

import java.util.Date ;

import javax.persistence.Column ;
import javax.persistence.GeneratedValue ;
import javax.persistence.Id ;
import javax.persistence.MappedSuperclass ;
import javax.persistence.Temporal ;
import javax.persistence.TemporalType ;
import javax.validation.constraints.NotNull ;

import org.hibernate.annotations.Type ;

import co.edu.unal.sam.aspect.model.enumerator.StateEnum ;

@MappedSuperclass
public class Entity {
  
  @Column(name = "date_register", nullable = false)
  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  private Date       dateRegister ;
  
  @Column(name = "date_update", nullable = false)
  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  private final Date dateUpdate ;
  
  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  private Long       id ;
  
  @Column(name = "name", nullable = false, length = 300)
  @NotNull
  private String     name ;
  
  @Column(name = "state_id", nullable = false)
  @NotNull
  @Type(type = "co.edu.unal.sam.aspect.model.usertype.StateUserType")
  private StateEnum  state ;
  
  public Entity() {
	this.dateRegister = new Date() ;
	this.dateUpdate = new Date() ;
	this.state = StateEnum.ACTIVE ;
  }
  
  @Override
  public boolean equals(final Object obj) {
	if (this == obj) {
	  return true ;
	}
	if (obj == null) {
	  return false ;
	}
	if (!(obj instanceof Entity)) {
	  return false ;
	}
	final Entity other = (Entity) obj ;
	if (this.id == null) {
	  if (other.id != null) {
		return false ;
	  }
	} else if (!this.id.equals(other.id)) {
	  return false ;
	}
	return true ;
  }
  
  public Date getDateRegister() {
	return this.dateRegister ;
  }

  /**
   * .
   * 
   * @return the dateUpdate
   */
  public Date getDateUpdate() {
	return this.dateUpdate ;
  }

  public Long getId() {
	return this.id ;
  }
  
  public String getName() {
	return this.name ;
  }
  
  public StateEnum getState() {
	return this.state ;
  }
  
  @Override
  public int hashCode() {
	final int prime = 31 ;
	int result = 1 ;
	result = (prime * result) + ((this.id == null) ? 0 : this.id.hashCode()) ;
	return result ;
  }
  
  public void setDateRegister(final Date dateRegister) {
	this.dateRegister = dateRegister ;
  }
  
  public void setId(final Long id) {
	this.id = id ;
  }
  
  public void setName(final String name) {
	this.name = name ;
  }
  
  public void setState(final StateEnum state) {
	this.state = state ;
  }
  
}
