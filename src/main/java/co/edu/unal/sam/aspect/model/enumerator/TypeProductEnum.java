package co.edu.unal.sam.aspect.model.enumerator;

import co.edu.unal.sam.aspect.model.enumerator.PersistentEnum;

public enum TypeProductEnum implements PersistentEnum {

	TIP((byte) 1, "Tip"), NEW((byte) 2, "New");

	private final Byte id;
	private final String name;

	private TypeProductEnum(Byte id, String name) {
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
