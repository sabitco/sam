package co.edu.unal.sam.physicalactivity.model.enumerator;

import co.edu.unal.sam.aspect.model.enumerator.PersistentEnum;

public enum TypeActivityEnum implements PersistentEnum {
    
    MODERATE((byte) 1, "Moderate"),
    VIGOROUS((byte) 2, "Vigorous");
    
    private final Byte id;
    private final String name;
    
    private TypeActivityEnum(final Byte id, final String name) {
        this.id = id;
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
