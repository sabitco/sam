package co.edu.unal.sam.aspect.model.enumerator;


public enum TypePageEnum implements PersistentEnum {

	ADMINISTRATOR((byte) 1, "Administrator"), PLAYER((byte) 2, "Player");

	private final Byte id;
	private final String name;

	private TypePageEnum(final Byte id, final String name) {
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
