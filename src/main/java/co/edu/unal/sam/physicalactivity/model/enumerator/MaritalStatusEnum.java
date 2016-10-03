package co.edu.unal.sam.physicalactivity.model.enumerator;

import co.edu.unal.sam.aspect.model.enumerator.PersistentEnum;

public enum MaritalStatusEnum implements PersistentEnum {

    MARRIED(1, "Soltero"), SINGLE(2, "Casado");

    private final Byte id;
    private final String name;

    private MaritalStatusEnum(final Integer id, final String name) {
        this.id = id.byteValue();
        this.name = name;
    }

    @Override
    public Byte getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
