package co.edu.unal.sam.physicalactivity.model.enumerator;

import co.edu.unal.sam.aspect.model.enumerator.PersistentEnum;

public enum TypeRiskEnum implements PersistentEnum {

    HIGH(1, "High"), INDETERMINATE(4, "Indeterminate"), LOW(3, "Low"), MEDIUM(2, "Medium");

    private final Byte id;
    private final String name;

    private TypeRiskEnum(Integer id, String name) {
        this.id = id.byteValue();
        this.name = name;
    }

    @Override
    public Byte getId() {
        return this.id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

}
