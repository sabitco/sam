package co.edu.unal.sam.physicalactivity.model.enumerator;

import co.edu.unal.sam.aspect.model.enumerator.PersistentEnum;

public enum TypeNewEnum implements PersistentEnum {

	NEW((byte) 1, "New"), PUBLICITY((byte) 2, "Publicity");

	private final Byte id;
	private final String name;

	private TypeNewEnum(Byte id, String name) {
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
