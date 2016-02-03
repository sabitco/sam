package co.edu.unal.sam.aspect.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;

import javax.validation.constraints.Null;

@javax.persistence.Entity
@javax.persistence.Table(name = "page")
public class Page extends Entity {

	@Column(name = "licence", nullable = true, length = 300)
	@Null
	private String licence;

	@Column(name = "url", nullable = true, length = 300)
	@Null
	private String url;

	@ManyToMany(mappedBy = "pages")
	private Set<Role> roles = new HashSet<>(0);

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

}
