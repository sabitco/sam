package co.edu.unal.sam.physicalactivity.model.dto;

/**
 * @author Andrés Mise Olivera
 *
 */
public class DiseaseDto extends Dto {

    private Boolean selected;

    public DiseaseDto() {}

    public DiseaseDto(Long id, String name) {
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
