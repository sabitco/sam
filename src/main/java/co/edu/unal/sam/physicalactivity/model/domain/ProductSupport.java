package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.enumerator.StateEnum;

@javax.persistence.Entity
@javax.persistence.Table(name = "product_support")
public class ProductSupport extends Entity {

	@Column(name = "producto_id", nullable = false)
	@NotNull
	private Integer productoID;

	@Column(name = "file_path", nullable = false, length = 300)
	@NotNull
	private String filePath;

	@Column(name = "type_user_id", nullable = false)
	@NotNull
	@Type(type = "co.edu.unal.sam.aspect.model.usertype.TypeProductType")
	private StateEnum typeuser;

	@Column(name = "url", nullable = false, length = 300)
	@NotNull
	private String url;

}
