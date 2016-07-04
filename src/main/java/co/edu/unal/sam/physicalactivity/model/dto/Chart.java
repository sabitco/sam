package co.edu.unal.sam.physicalactivity.model.dto;

public class Chart extends Dto {

    private Long value;

    public Chart(String name, Long value) {
        super.name = name;
        this.value = value;
    }

    /**
     * @return the value
     */
    public Long getValue() {
        return this.value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Long value) {
        this.value = value;
    }

}
