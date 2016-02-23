import java.util.ArrayList;
import java.util.Optional;

public class BstImplem implements Bst {
	
	private ArrayList<Node> nodes;
	
	public BstImplem() {
		
	}

	@Override
	/**
	 * Is the BST Empty?
	 * @return Whether or not the BST is empty.
	 */
	public boolean isEmpty() {
		return this.nodes.isEmpty();
	}

	@Override
	public boolean smaller(Comparable k) {
		for(Node node : this.nodes) {
			if(node.getKey().compareTo(k) == 1) return false;
		}
		return true;
	}

	@Override
	public boolean bigger(Comparable k) {
		for(Node node : this.nodes) {
			if(node.getKey().compareTo(k) == -1) return false;
		}
		return true;
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
