package co.edu.unal.sam.physicalactivity.model.dto;

import java.util.ArrayList;
import java.util.List;

public class Statistic extends Dto {

    private List<Chart> chart;
    private Long goal;
    private Long current;

    public Statistic(final String name, Long advance, Integer goal, Long current) {
        super.name = name;
        this.goal = goal.longValue();
        this.current = current;
        this.chart = new ArrayList<>();
        if (advance > 99) {
            advance = 99L;
        }
        this.chart.add(new Chart(name, advance > 99 ? 99 : advance));
        this.chart.add(new Chart("Te falta " + name, advance > 99 ? 1 : 100 - advance));
    }

    /**
     * @return the chart
     */
    public List<Chart> getChart() {
        return this.chart;
    }

    /**
     * @param chart the chart to set
     */
    public void setChart(List<Chart> chart) {
        this.chart = chart;
    }

    /**
     * @return the goal
     */
    public Long getGoal() {
        return this.goal;
    }

    /**
     * @param goal the goal to set
     */
    public void setGoal(Long goal) {
        this.goal = goal;
    }

    /**
     * @return the current
     */
    public Long getCurrent() {
        return this.current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(Long current) {
        this.current = current;
    }

}
