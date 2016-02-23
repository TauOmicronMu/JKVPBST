import java.util.Optional;

public class Empty implements Bst {
	
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
	public boolean smaller(Comparable k) {
		return true;
	}

	/**
	 * Always returns true because there are
	 * no nodes in an Empty BST.
	 */
	@Override
	public boolean bigger(Comparable k) {
		return true;
	}

	/**
	 * Always returns false because an Empty
	 * BST will never contain the key, k.
	 */
	@Override
	public boolean has(Comparable k) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Always return an empty instance of
	 * the Optional class, because there
	 * are never nodes in an Empty BST.
	 */
	@Override
	public Optional find(Comparable k) {
		return Optional.empty();
	}

	/**
	 * Return a Fork with just a root, which
	 * is an Entry consisting of the key:value 
	 * pair: k:v.
	 */
	@Override
	public Bst put(Comparable k, Object v) {
		return new Fork(new Entry<>(k,v), new Empty(), new Empty());
	}

	/** 
	 * Always return an empty instance of
	 * the Optional class, because there are
	 * never nodes in an Empty BST.
	 */
	@Override
	public Optional delete(Comparable k) {
		return Optional.empty();
	}

	/** 
	 * Always return an empty instance of
	 * the Optional class, because there are
	 * never nodes in an Empty BST.
	 */
	@Override
	public Optional smallest() {
		return Optional.empty();
	}

	/** 
	 * Always return an empty instance of
	 * the Optional class, because there are
	 * never nodes in an Empty BST.
	 */
	@Override
	public Optional deleteSmallest() {
		return Optional.empty();
	}

	/** 
	 * Always return an empty instance of
	 * the Optional class, because there are
	 * never nodes in an Empty BST.
	 */
	@Override
	public Optional largest() {
		return Optional.empty();
	}

	/**
	 * There is nothing to delete, so always
	 * return an empty instance of the
	 * Optional class.
	 */
	@Override
	public Optional deleteLargest() {
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
		// TODO Auto-generated method stub
		System.out.println("Empty");
	}
	
	/**
	 * TODO : Implement this.
	 */
	@Override
	public void saveInOrder(Entry[] a) {
		// TODO Auto-generated method stub
	}

	/**
	 * TODO : Implement this.
	 */
	@Override
	public int saveInOrder(Entry[] a, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Always returns an Empty BST because
	 * the Empty BST is always balanced.
	 */
	@Override
	public Bst balanced() {
		return new Empty();
	}

}
