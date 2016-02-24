/**
 * A single Node in a Binary Search Tree.
 * This holds a kev-value pair, where the Key is a Comparable and the
 * Value is an Object.
 * 
 * Nodes are immutable.
 * @author txg523
 *
 */
public class Node {
    private final Comparable key;
    private final Object value;
    
    /**
     * Create a new Node object with the given
     * key and value.
     * @param key The key for the key-value pair.
     * @param value  The value for the key-value pair.
     */
    public Node(Comparable key, Object value) {
    	this.key = key;
    	this.value = value;
    }

    /**
     * Returns the key of the node.
     * @return The key, which is a Comparable.
     */
	public Comparable getKey() {
		return key;
	}

	/**
	 * Returns the value of the node.
	 * @return THe value, which is an Object.
	 */
	public Object getValue() {
		return value;
	}
}
