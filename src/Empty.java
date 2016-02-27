import java.util.Optional;

public class Empty<K extends Comparable<K>,V> implements Bst<K,V> {
	
	/**
	 * Nothing to do in the constructor.
	 */
	public Empty(){}
    
	/**
	 * Always returns true because an Empty
	 * BST is always Empty.
	 */
	@Override
	public boolean isEmpty() {
		return true;
	}

	/**
	 * Always returns true because there are
	 * no nodes in an Empty BST.
	 */
	@Override
	public boolean smaller(K k) {
		return true;
	}

	/**
	 * Always returns true because there are
	 * no nodes in an Empty BST.
	 */
	@Override
	public boolean bigger(K k) {
		return true;
	}

	/**
	 * Always returns false because an Empty
	 * BST will never contain the key, k.
	 */
	@Override
	public boolean has(K k) {
		return false;
	}

	/**
	 * Always return an empty instance of
	 * the Optional class, because there
	 * are never nodes in an Empty BST.
	 */
	@Override
	public Optional<V> find(K k) {
		return Optional.empty();
	}

	/**
	 * Return a Fork with just a root, which
	 * is an Entry consisting of the key:value 
	 * pair: k:v.
	 */
	@Override
	public Bst<K,V> put(K k, V v) {
		return new Fork<K,V>(new Entry<K,V>(k,v), new Empty<K,V>(), new Empty<K,V>());
	}

	/** 
	 * Always return an empty instance of
	 * the Optional class, because there are
	 * never nodes in an Empty BST.
	 */
	@Override
	public Optional<Bst<K,V>> delete(K k) {
		return Optional.empty();
	}

	/** 
	 * Always return an empty instance of
	 * the Optional class, because there are
	 * never nodes in an Empty BST.
	 */
	@Override
	public Optional<Entry<K,V>> smallest() {
		return Optional.empty();
	}

	/** 
	 * Always return an empty instance of
	 * the Optional class, because there are
	 * never nodes in an Empty BST.
	 */
	@Override
	public Optional<Bst<K,V>> deleteSmallest() {
		return Optional.empty();
	}

	/** 
	 * Always return an empty instance of
	 * the Optional class, because there are
	 * never nodes in an Empty BST.
	 */
	@Override
	public Optional<Entry<K,V>> largest() {
		return Optional.empty();
	}

	/**
	 * There is nothing to delete, so always
	 * return an empty instance of the
	 * Optional class.
	 */
	@Override
	public Optional<Bst<K,V>> deleteLargest() {
		return Optional.empty();
	}
	
	/**
	 * Just prints "Empty".
	 */
	public String toString() {
		return "Empty";
	}

	/**
	 * Prints 'nothing'.
	 */
	@Override
	public String fancyToString() {
		return "";
	}

	/**
	 * Prints 'nothing'.
	 */
	public String fancyToString(int d) {
		return "";
	}

	/**
	 * Always returns 0, because the Empty
	 * BST contains 0 nodes.
	 */
	@Override
	public int size() {
		return 0;
	}

	/**
	 * Always returns -1, because an Empty
	 * BST has a height of -1.
	 */
	@Override
	public int height() {
		return -1;
	}

	/**
	 * Just print out "Empty".
	 */
	@Override
	public void printInOrder() {
		System.out.println("Empty");
	}
	
	/**
	 * Nothing is added to the array, so just do nothing.
	 */
	@Override
	public void saveInOrder(Entry<K,V>[] a) {
	    //Do nothing.
	}

	/**
	 * Nothing is added to the array, so always return i.
	 */
	@Override
	public int saveInOrder(Entry<K,V>[] a, int i) {
		return i;
	}

	/**
	 * Always returns an Empty BST because
	 * the Empty BST is always balanced.
	 */
	@Override
	public Bst<K,V> balanced() {
		return new Empty<K,V>();
	}

}
