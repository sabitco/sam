package co.edu.unal.sam.aspect.model.enumerator ;

/**
 * The Enum TypePageEnum.
 */
public enum TypePageEnum implements PersistentEnum {
  
  /** The active. */
  ADMINISTRATOR((byte) 1, "Administrator", true),
  
  /** The inactive. */
  PLAYER((byte) 2, "Player", true) ;
  
  /** The available. */
  private final Boolean available ;
  
  /** The id. */
  private final Byte    id ;
  
  /** The name. */
  private final String  name ;
  
  /**
   * Instantiates a new type page enum.
   *
   * @param id the id
   * @param name the name
   * @param available the available
   */
  private TypePageEnum(final Byte id, final String name, final Boolean available) {
	this.id = id ;
	this.name = name ;
	this.available = available ;
  }
  
  /**
   * Gets the available.
   *
   * @return the available
   */
  public Boolean getAvailable() {
	return this.available ;
  }
  
  /**
   * Gets the id.
   *
   * @return the id
   */
  @Override
  public Byte getId() {
	return this.id ;
  }
  
  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
	return this.name ;
  }
  
}
