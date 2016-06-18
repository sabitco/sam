package co.edu.unal.sam.physicalactivity.model.dto;

public class GoalDto {

    private ActivityDto activity;
    private Integer currentDays;
    private Integer currentMinutes;
    private Integer days;
    private Long id;
    private Integer minutes;
    private Boolean selected;

    public GoalDto(ActivityDto activity, Long id, Integer days, Integer minutes, Boolean selected) {
        super();
        this.activity = activity;
        this.id = id;
        this.days = days;
        this.minutes = minutes;
        this.selected = selected;
        this.currentMinutes = 0;
        this.currentDays = 0;
    }

    /**
     * @return the activity
     */
    public ActivityDto getActivity() {
        return this.activity;
    }

    /**
     * @return the currentDays
     */
    public Integer getCurrentDays() {
        return this.currentDays;
    }

    /**
     * @return the currentMinutes
     */
    public Integer getCurrentMinutes() {
        return this.currentMinutes;
    }

    /**
     * @return the days
     */
    public Integer getDays() {
        return this.days;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return this.id;
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
     * @param activity the activity to set
     */
    public void setActivity(ActivityDto activity) {
        this.activity = activity;
    }

    /**
     * @param currentDays the currentDays to set
     */
    public void setCurrentDays(Integer currentDays) {
        this.currentDays = currentDays;
    }

    /**
     * @param currentMinutes the currentMinutes to set
     */
    public void setCurrentMinutes(Integer currentMinutes) {
        this.currentMinutes = currentMinutes;
    }

    /**
     * @param days the days to set
     */
    public void setDays(Integer days) {
        this.days = days;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
