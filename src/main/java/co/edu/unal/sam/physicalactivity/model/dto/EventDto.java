package co.edu.unal.sam.physicalactivity.model.dto;

import java.util.Date;

public class EventDto extends Dto {

    private Date date;

    public EventDto() {}

    public EventDto(Long id, String name, Date date) {
        super(id, name);
        this.date = date;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
