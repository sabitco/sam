package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "preselection_response_preselection")
public class PreselectionResponsePreselection extends Entity {
    
	@Column(name = "response", nullable = false, length = 300)
	@Null
	private String response;

	@ManyToOne()
	@JoinColumn(name = "response_preselection_id", nullable = false)
	@NotNull
	private ResponsePreselection responsePreselection;
	
	@ManyToOne()
	@JoinColumn(name = "preselection_id", nullable = false)
	@NotNull
	private Preselection preselection;

}
