package co.edu.unal.sam.physicalactivity.model.dto;

public class Statistic extends Dto {

    private Long advance;

    public Statistic(final String name, Long advance) {
        super.name = name;
        this.advance = advance;
        if (this.advance > 99) {
            this.advance = 99L;
        }
    }

    /**
     * @return the advance
     */
    public Long getAdvance() {
        return this.advance;
    }

    /**
     * @param advance the advance to set
     */
    public void setAdvance(Long advance) {
        this.advance = advance;
    }

}
