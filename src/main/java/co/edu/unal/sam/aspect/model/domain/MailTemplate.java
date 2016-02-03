package co.edu.unal.sam.aspect.model.domain;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@javax.persistence.Entity
@javax.persistence.Table(name = "mail_template")
public class MailTemplate extends Entity {

	@Column(name = "body", columnDefinition = "TEXT", nullable = false)
	@NotNull
	private String body;

	@Column(name = "cc", nullable = true, length = 300)
	@Null
	private String cc;

	@Column(name = "cco", nullable = true, length = 300)
	@Null
	private String cco;

	@Column(name = "subject", nullable = false, length = 300)
	@NotNull
	private String subject;

	@Column(name = "too", nullable = false, length = 300)
	@NotNull
	private String too;

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the cc
	 */
	public String getCc() {
		return cc;
	}

	/**
	 * @param cc
	 *            the cc to set
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}

	/**
	 * @return the cco
	 */
	public String getCco() {
		return cco;
	}

	/**
	 * @param cco
	 *            the cco to set
	 */
	public void setCco(String cco) {
		this.cco = cco;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the too
	 */
	public String getToo() {
		return too;
	}

	/**
	 * @param too
	 *            the too to set
	 */
	public void setToo(String too) {
		this.too = too;
	}

}
