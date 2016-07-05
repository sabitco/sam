package co.edu.unal.sam.physicalactivity.model.dto;

public class Chart extends Dto {

    private String label;
    private Long value;

    public Chart(final String name, final Long value) {
        // super.name = namZe;
        this.value = value;
        this.label = name;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * @return the value
     */
    public Long getValue() {
        return this.value;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(final String label) {
        this.label = label;
    }

    /**
     * @param value the value to set
     */
    public void setValue(final Long value) {
        this.value = value;
    }



}
