package co.edu.unal.sam.physicalactivity.model.dto;

import co.edu.unal.sam.physicalactivity.model.enumerator.IntensityEnum;

public class ActivityDto extends Dto {

    private Integer days;
    private IntensityEnum intensity;
    private Integer minutes;
    private Boolean selected;

    public ActivityDto() {}

    public ActivityDto(Long id, String name, Boolean selected) {
        super(id, name);
        this.selected = selected;
    }

    public ActivityDto(Long id, String name, Boolean selected, IntensityEnum intensity,
            Integer days, Integer minutes) {
        this(id, name, selected);
        this.intensity = intensity;
        this.days = days;
        this.minutes = minutes;
    }

    /**
     * @return the days
     */
    public Integer getDays() {
        return this.days;
    }

    /**
     * @return the intensity
     */
    public IntensityEnum getIntensity() {
        return this.intensity;
    }

    /**
     * @return the minutes
     */
    public Integer getMinutes() {
        return this.minutes;
    }

    /**
     * @return the selected
     */
    public Boolean getSelected() {
        return this.selected;
    }

    /**
     * @param days the days to set
     */
    public void setDays(Integer days) {
        this.days = days;
    }

    /**
     * @param intensity the intensity to set
     */
    public void setIntensity(IntensityEnum intensity) {
        this.intensity = intensity;
    }

    /**
     * @param minutes the minutes to set
     */
    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

}
