package co.edu.unal.sam.aspect.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import co.edu.unal.sam.aspect.model.domain.Authorization;

@javax.persistence.Entity
@javax.persistence.Table(name = "role")
public class Role extends Entity {

	@ManyToMany()
	@JoinTable(name = "role_authorization", joinColumns = { @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "fk_role_authorization_role")) }, inverseJoinColumns = { @JoinColumn(name = "authorization_id", nullable = false, foreignKey = @ForeignKey(name = "fk_role_authorization_authorization")) })
	private Set<Authorization> authorizations = new HashSet<>(0);

	@ManyToMany()
	@JoinTable(name = "role_page", joinColumns = { @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "fk_role_page_role")) }, inverseJoinColumns = { @JoinColumn(name = "page_id", nullable = false, foreignKey = @ForeignKey(name = "fk_role_page_page")) })
	private Set<Page> pages = new HashSet<>(0);

	/**
	 * @return the authorizations
	 */
	public Set<Authorization> getAuthorizations() {
		return authorizations;
	}

	/**
	 * @param authorizations
	 *            the authorizations to set
	 */
	public void setAuthorizations(Set<Authorization> authorizations) {
		this.authorizations = authorizations;
	}

	/**
	 * @return the pages
	 */
	public Set<Page> getPages() {
		return pages;
	}

	/**
	 * @param pages
	 *            the pages to set
	 */
	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}

}
