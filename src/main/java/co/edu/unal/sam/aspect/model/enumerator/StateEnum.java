package co.edu.unal.sam.aspect.model.enumerator;

import co.edu.unal.sam.aspect.model.enumerator.PersistentEnum;

public enum StateEnum implements PersistentEnum {
    
    ACTIVE((byte) 1, "Active"), 
    INACTIVE((byte) 2, "Inactive");
    
    private final Byte id;
    private final String name;

    private StateEnum(Byte id, String name) {
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
