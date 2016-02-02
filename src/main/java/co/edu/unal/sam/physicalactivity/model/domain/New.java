package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.Type;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.enumerator.StateEnum;

@javax.persistence.Entity
@javax.persistence.Table(name = "new")
public class New extends Entity {

	@Column(name = "body", columnDefinition = "TEXT", nullable = false)
	@NotNull
	private String body;

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

	@Column(name = "tag", nullable = false, length = 300)
	@NotNull
	private String tag;

	@Column(name = "type_user_id", nullable = false)
	@NotNull
	@Type(type = "co.edu.unal.sam.physicalactivity.model.usertype.TypeNewType")
	private StateEnum typeuser;
}
