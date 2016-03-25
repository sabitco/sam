package co.edu.unal.sam.aspect.model.enumerator ;

/**
 * The Enum StateEnum.
 */
public enum StateEnum implements PersistentEnum {
  
  /** The active. */
  ACTIVE((byte) 1, "Active", true),
  
  /** The inactive. */
  INACTIVE((byte) 2, "Inactive", true) ;
  
  /** The available. */
  private final Boolean available ;
  
  /** The id. */
  private final Byte    id ;
  
  /** The name. */
  private final String  name ;
  
  /**
   * Instantiates a new state enum.
   *
   * @param id the id
   * @param name the name
   * @param available the available
   */
  private StateEnum(final Byte id, final String name, final Boolean available) {
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
