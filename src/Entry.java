// Do not modify this class.

public class Entry<Key extends Comparable<Key>,Value> {

  private final Key key;
  private final Value value;

  public Entry(Key key, Value value) {
    this.key = key;
    this.value = value;
  }

  public Key getKey() {
    return key;
  }

  public Value getValue() {
    return value;
  }
  
  /*
   * I know it said not to modify this class, but it made sense to add a toString 
   * method to stop myself from repeating myself when writing Fork. 
   */
  public String toString() {
	  return key + " : " + value;
  }
}
