package co.edu.unal.sam.physicalactivity.model.enumerator;

import co.edu.unal.sam.aspect.model.enumerator.PersistentEnum;

/**
 * Body Mass Index Categories
 * 
 * @author Andrés Mise Olivera
 *
 */
public enum BmiCategoryEnum implements PersistentEnum {

    /**
     * Mild Thinness
     */
    MILD_THINNESS((byte) 3, "Delgadez aceptable", 17.00, 18.49),

    /**
     * Moderate Thinness
     */
    MODERATE_THINNESS((byte) 2, "Delgadez moderada", 16.00, 16.99),

    /**
     * Normal Weight
     */
    NORMAL_WEIGHT((byte) 4, "Peso Normal", 18.50, 24.99),

    /**
     * Obese Class I
     */
    OBESE_CLASS_I((byte) 6, "Obeso: Tipo I", 30.00, 34.99),

    /**
     * Obese Class II
     */
    OBESE_CLASS_II((byte) 7, "Obeso: Tipo II", 35.00, 39.99),

    /**
     * Obese Class III
     */
    OBESE_CLASS_III((byte) 8, "Obeso: Tipo III", 40.00, 100.00),

    /**
     * Overweight
     */
    OVERWEIGHT((byte) 5, "Sobrepeso", 25.00, 29.99),

    /**
     * Severe Thinness
     */
    SEVERE_THINNESS((byte) 1, "Delgadez Severa", 0D, 15.99);

    public static BmiCategoryEnum getCategory(Float bmi) {
        BmiCategoryEnum category = null;
        // Truncate a double to only two decimal places
        bmi = (float) (Math.floor(bmi * 100) / 100);
        for (BmiCategoryEnum c : BmiCategoryEnum.values()) {
            if (bmi >= c.from && bmi <= c.to) {
                category = c;
                break;
            }
        }
        return category;
    }

    private final Double from;
    private final Byte id;
    private final String name;
    private final Double to;

    private BmiCategoryEnum(Byte id, String name, Double from, Double to) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
    }

    @Override
    public Byte getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
