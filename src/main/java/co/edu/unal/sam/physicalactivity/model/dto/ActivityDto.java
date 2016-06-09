package co.edu.unal.sam.physicalactivity.model.dto;

public class ActivityDto extends Dto {

    private Boolean selected;

    public ActivityDto() {}

    public ActivityDto(Long id, String name, Boolean selected) {
        super(id, name);
        this.selected = selected;
    }

    /**
     * @return the selected
     */
    public Boolean getSelected() {
        return this.selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

}
