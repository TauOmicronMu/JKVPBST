import java.util.Optional;

public class Fork<K extends Comparable<K>,V> implements Bst {

	private final Entry root;
	private final Bst left, right;
	
	/**
	 * Creates a new instance of the Fork class,
	 * ensuring that neither branch is null and
	 * the new Fork wouldn't violate the BST
	 * property.
	 * @param root The root value for the BST.
	 * @param left The left branch for the BST.
	 * @param right The right branch for the BST.
	 */
	public Fork(Entry root, Bst left, Bst right) {
		
		assert(left != null && right != null); //Neither of the branches should be null.
		
		assert(left.smaller(root.getKey()) && right.bigger(root.getKey())); //Don't violate the BST property.
		
		this.root = root;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Always return false, because a Fork
	 * will always have at least a root
	 * node.
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean smaller(Comparable k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bigger(Comparable k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean has(Comparable k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional find(Comparable k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bst put(Comparable k, Object v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional delete(Comparable k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional smallest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional deleteSmallest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional largest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional deleteLargest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fancyToString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fancyToString(int d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printInOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveInOrder(Entry[] a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int saveInOrder(Entry[] a, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Bst balanced() {
		// TODO Auto-generated method stub
		return null;
	}

}
