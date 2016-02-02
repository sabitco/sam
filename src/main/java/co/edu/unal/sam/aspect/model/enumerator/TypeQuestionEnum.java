package co.edu.unal.sam.aspect.model.enumerator;

import co.edu.unal.sam.aspect.model.enumerator.PersistentEnum;

public enum TypeQuestionEnum implements PersistentEnum {

	CLOSE((byte) 2, "Close"), OPEN((byte) 1, "Open");

	private final Byte id;
	private final String name;

	private TypeQuestionEnum(Byte id, String name) {
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
