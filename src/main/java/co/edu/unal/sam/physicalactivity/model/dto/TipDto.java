package co.edu.unal.sam.physicalactivity.model.dto;

public class TipDto extends Dto {

    private String description;

    public TipDto() {}

    public TipDto(Long id, String name, String description) {
        super(id, name);
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
