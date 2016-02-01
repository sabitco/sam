package co.edu.unal.sam.aspect.model.enumerator;

import co.edu.unal.sam.aspect.model.domain.PersistentEnum;

public enum TypeUserEnum implements PersistentEnum {

	ADMINISTRATOR((byte) 1, "Administrator"), PLAYER((byte) 2, "Player");

	private final Byte id;
	private final String name;

	private TypeUserEnum(Byte id, String name) {
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
