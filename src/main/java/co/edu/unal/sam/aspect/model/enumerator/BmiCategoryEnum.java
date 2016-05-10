package co.edu.unal.sam.aspect.model.enumerator;

/**
 * Body Mass Index Categories
 * 
 * @author Andrés Mise Olivera
 *
 */
public enum BmiCategoryEnum {

    /**
     * Severe Thinness
     */
    SEVERE_THINNESS(0D, 15.99),

    /**
     * Moderate Thinness
     */
    MODERATE_THINNESS(16.00, 16.99),

    /**
     * Mild Thinness
     */
    MILD_THINNESS(17.00, 18.49),

    /**
     * Normal Weight
     */
    NORMAL_WEIGHT(18.50, 24.99),

    /**
     * Overweight
     */
    OVERWEIGHT(25.00, 29.99),

    /**
     * Obese Class I
     */
    OBESE_CLASS_I(30.00, 34.99),

    /**
     * Obese Class II
     */
    OBESE_CLASS_II(35.00, 39.99),

    /**
     * Obese Class III
     */
    OBESE_CLASS_III(40.00, 100.00);

    private final Double from;
    private final Double to;

    private BmiCategoryEnum(Double from, Double to) {
        this.from = from;
        this.to = to;
    }

    public static BmiCategoryEnum getCategory(Double bmi) {
        BmiCategoryEnum category = null;
        // Truncate a double to only two decimal places
        bmi = Math.floor(bmi * 100) / 100;
        for (BmiCategoryEnum c : BmiCategoryEnum.values()) {
            if (bmi >= c.from && bmi <= c.to) {
                category = c;
                break;
            }
        }
        return category;
    }
}
