package co.edu.unal.sam.physicalactivity.model.enumerator;

import co.edu.unal.sam.aspect.model.enumerator.PersistentEnum;

public enum TermEnum implements PersistentEnum {

    LONG(1, "Largo plazo"), MEDIUM(2, "Mediano plazo"), SHORT(3, "Corto plazo");

    private final Byte id;
    private final String name;

    private TermEnum(Integer id, String name) {
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
