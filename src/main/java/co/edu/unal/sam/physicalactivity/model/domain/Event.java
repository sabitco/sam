package co.edu.unal.sam.physicalactivity.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.unal.sam.aspect.model.domain.Entity;

@javax.persistence.Entity
@javax.persistence.Table(name = "event")
@NamedQueries({@NamedQuery(name = "Event.findDtoAll",
        query = "select new co.edu.unal.sam.physicalactivity.model.dto.EventDto(e.id, e.name, e.date, e.link, e.slug) "
                + "from Event e where e.state = :state"),})
public class Event extends Entity {

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "link")
    private String link;
    
    @Column(name = "slug")
    private String slug;

    public Event() {}

    /**
     * @return the date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return this.link;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

}
