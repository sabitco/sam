package co.edu.unal.sam.aspect.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.Type;

import co.edu.unal.sam.aspect.model.enumerator.TypeAuthorizationEnum;

@javax.persistence.Entity
@javax.persistence.Table(name = "authorization")
public class Authorization extends Entity {

	@ManyToMany(mappedBy = "authorizations")
	private Set<Role> roles = new HashSet<>(0);

	@Column(name = "licence", nullable = true, length = 300)
	@Null
	private String licence;

	@Column(name = "page_name", nullable = true, length = 300)
	@Null
	private String pageName;

	@Column(name = "parent", nullable = true, length = 300)
	@Null
	private String parent;

	@Column(name = "type_user_id", nullable = false)
	@NotNull
	@Type(type = "co.edu.unal.sam.aspect.model.usertype.TypeAuthorizationUserType")
	private TypeAuthorizationEnum typeAuthorization;

	@Column(name = "url", nullable = true, length = 300)
	@Null
	private String url;

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the licence
	 */
	public String getLicence() {
		return licence;
	}

	/**
	 * @param licence
	 *            the licence to set
	 */
	public void setLicence(String licence) {
		this.licence = licence;
	}

	/**
	 * @return the pageName
	 */
	public String getPageName() {
		return pageName;
	}

	/**
	 * @param pageName
	 *            the pageName to set
	 */
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	/**
	 * @return the parent
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * @return the typeAuthorization
	 */
	public TypeAuthorizationEnum getTypeAuthorization() {
		return typeAuthorization;
	}

	/**
	 * @param typeAuthorization
	 *            the typeAuthorization to set
	 */
	public void setTypeAuthorization(TypeAuthorizationEnum typeAuthorization) {
		this.typeAuthorization = typeAuthorization;
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
