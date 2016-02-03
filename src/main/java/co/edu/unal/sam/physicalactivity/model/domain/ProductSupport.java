package co.edu.unal.sam.physicalactivity.model.domain;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import co.edu.unal.sam.aspect.model.domain.Entity;
import co.edu.unal.sam.aspect.model.enumerator.TypeProductEnum;

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
	@Type(type = "co.edu.unal.sam.aspect.model.usertype.TypeProductUserType")
	private TypeProductEnum typeProduct;

	@Column(name = "url", nullable = false, length = 300)
	@NotNull
	private String url;

	/**
	 * @return the productoID
	 */
	public Integer getProductoID() {
		return productoID;
	}

	/**
	 * @param productoID
	 *            the productoID to set
	 */
	public void setProductoID(Integer productoID) {
		this.productoID = productoID;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath
	 *            the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @return the typeProduct
	 */
	public TypeProductEnum getTypeProduct() {
		return typeProduct;
	}

	/**
	 * @param typeProduct
	 *            the typeProduct to set
	 */
	public void setTypeProduct(TypeProductEnum typeProduct) {
		this.typeProduct = typeProduct;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
