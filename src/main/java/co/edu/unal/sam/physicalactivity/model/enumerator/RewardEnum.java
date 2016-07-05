package co.edu.unal.sam.physicalactivity.model.enumerator;

import co.edu.unal.sam.aspect.model.enumerator.PersistentEnum;

public enum RewardEnum implements PersistentEnum {

    GOLD(1, "Gold"), PLATINUM(2, "Platino"), SAPPHIRE(3, "Zafiro");

    private Byte id;
    private String name;

    private RewardEnum(Integer id, String name) {
        this.id = id.byteValue();
        this.name = name;
    }

    /**
     * @return the id
     */
    @Override
    public Byte getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Byte id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
