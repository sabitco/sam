package co.edu.unal.sam.physicalactivity.model.dto;

import java.util.Date;

public class EventDto extends Dto {

    private Date date;
    private String link;

    public EventDto() {}

    public EventDto(Long id, String name, Date date, String link) {
        super(id, name);
        this.date = date;
        this.link = link;
    }

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

}
