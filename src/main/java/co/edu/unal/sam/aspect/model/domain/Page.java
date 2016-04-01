package co.edu.unal.sam.aspect.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;

import co.edu.unal.sam.aspect.model.enumerator.TypePageEnum;

@javax.persistence.Entity
@javax.persistence.Table(name = "page")
public class Page extends Entity {

	@Column(name = "base", nullable = true, length = 300)
	private String base;

	@Column(name = "description_list", nullable = true, length = 300)
	private String descriptionList;
	
	@Column(name = "description_list_recent", nullable = true, length = 300)
	private String descriptionListRecent;

	@Column(name = "description_page", nullable = true, length = 300)
	private String descriptionPage;

	@Column(name = "icone", nullable = true, length = 300)
	private String icone;

	@Column(name = "name_page", nullable = true, length = 300)
	private String namePage;

	@Column(name = "name_page_all", nullable = true, length = 300)
	private String namePageAll;
	
	@Column(name = "order_page", nullable = true)
	private Integer orderPage;

	@ManyToMany(mappedBy = "pages")
	private final Set<Role> roles = new HashSet<>(0);

	@Column(name = "title", nullable = true, length = 300)
	private String title;

	@Column(name = "type_page_id", nullable = false)
	@Type(type = "co.edu.unal.sam.aspect.model.usertype.TypePageType")
	private TypePageEnum typePage;

	@Column(name = "url", nullable = true, length = 300)
	private String url;

	/**
	 * @return the base
	 */
	public String getBase() {
		return this.base;
	}

	/**
	 * @return the descriptionList
	 */
	public String getDescriptionList() {
		return this.descriptionList;
	}
	
	/**
	 * @return the descriptionList
	 */
	public String getDescriptionListRecent() {
		return this.descriptionListRecent;
	}
	
	/**
	 * @return the descriptionPage
	 */
	public String getDescriptionPage() {
		return this.descriptionPage;
	}

	/**
	 * @return the icone
	 */
	public String getIcone() {
		return this.icone;
	}

	/**
	 * @return the namePage
	 */
	public String getNamePage() {
		return this.namePage;
	}

	/**
	 * @return the namePage
	 */
	public String getNamePageAll() {
		return this.namePageAll;
	}

	/**
	 * @return the orderPage
	 */
	public Integer getOrderPage() {
		return this.orderPage;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return this.roles;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @return the typePage
	 */
	public TypePageEnum getTypePage() {
		return this.typePage;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * @param base
	 *            the base to set
	 */
	public void setBase(final String base) {
		this.base = base;
	}

	/**
	 * @param descriptionList
	 *            the descriptionList to set
	 */
	public void setDescriptionList(final String descriptionList) {
		this.descriptionList = descriptionList;
	}
	
	/**
	 * @param descriptionList
	 *            the descriptionList to set
	 */
	public void setDescriptionListRecent(final String descriptionListRecent) {
		this.descriptionListRecent = descriptionListRecent;
	}

	/**
	 * @param descriptionPage
	 *            the descriptionPage to set
	 */
	public void setDescriptionPage(final String descriptionPage) {
		this.descriptionPage = descriptionPage;
	}

	/**
	 * @param icone
	 *            the icone to set
	 */
	public void setIcone(final String icone) {
		this.icone = icone;
	}

	/**
	 * @param namePage
	 *            the namePage to set
	 */
	public void setNamePage(final String namePage) {
		this.namePage = namePage;
	}

	/**
	 * @param namePageAll
	 *            the namePageAll to set
	 */
	public void setNamePageAll(final String namePageAll) {
		this.namePageAll = namePageAll;
	}

	/**
	 * @param orderPage
	 *            the orderPage to set
	 */
	public void setOrderPage(final Integer orderPage) {
		this.orderPage = orderPage;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * @param typePage
	 *            the typePage to set
	 */
	public void setTypePage(final TypePageEnum typePage) {
		this.typePage = typePage;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(final String url) {
		this.url = url;
	}

}
