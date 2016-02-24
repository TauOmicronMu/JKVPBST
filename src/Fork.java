import java.util.Optional;

public class Fork<K extends Comparable<K>,V> implements Bst<K,V> {

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
	public Fork(Entry<K,V> root, Bst<K,V> left, Bst<K,V> right) {
		
		assert(left != null && right != null); //Neither of the branches should be null.
		
		assert(left.smaller(root.getKey()) && right.bigger(root.getKey())); //Don't violate the BST property.
		
		this.root = root;
		this.left = left;
		this.right = right;
	}
	
	public Comparable<K> getRootKey() {
		return this.root.getKey();
	}
	
	/**
	 * Always return false, because a Fork
	 * will always have at least a root
	 * node.
	 * 
	 * @return Whether or not the Fork is empty (this is always false).
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	/**
	 * Does every node have it's key smaller than k?
	 * 
	 * @return Whether or not all keys are lower than k.
	 * @param k The value that we are checking whether or not all keys are smaller than.
	 */
	@Override
	public boolean smaller(Comparable k) {
		/* CASE : BOTH BRANCHES ARE EMPTY
		 * 
		 * If both branches are empty, we're at the bottom of the BST.
		 */
		if(this.left instanceof Empty) {
			if(this.right instanceof Empty) {
				return true; // We are at the bottom of the branch and there are no conflicts.
			}
			/* CASE : THE LEFT BRANCH IS EMPTY BUT THE RIGHT BRANCH IS NOT
			 * 
			 * If the root value of the right Fork is less
			 * than k, return the value of smaller on the
			 * right fork.
			 * 
			 * We can cast this.right to a Fork safely, because we know that it isn't Empty, 
			 * and it can only be either Empty or a Fork.
			 */
			else if((k.compareTo(((Fork<K,V>)this.right).getRootKey())) > 0) {
				    return this.right.smaller(k);
			}
			/* 
			 * There is a key > k at the root of the right Fork. Hence, return false.
			 */
			else {
				return false;
			}
		}
	    /* CASE : THE RIGHT BRANCH IS EMPTY BUT THE LEFT BRANCH IS NOT
	     * 
	     * If the root value of the left Fork is less
	     * than k, return the value of smaller on the
	     * left fork. (If the right Fork is Empty). 
	     */
		else if(this.right instanceof Empty) {
			if((k.compareTo(((Fork<K,V>)this.left).getRootKey())) > 0) {
			    return this.left.smaller(k);
			}
			/* 
			 * There is a key > k at the root of the left Fork. Hence, return false.
			 */
			else {
				return false;
			}
		}
		/* CASE : NEIHER BRANCH IS EMPTY
		 * 
		 * If the root value of both Forks is less
		 * than k, return the value of smaller on the
		 * left fork and then right fork.
		 */
		else {
			if(((k.compareTo(((Fork<K,V>)this.left).getRootKey())) > 0) && ((k.compareTo(((Fork<K,V>)this.right).getRootKey())) > 0)) {
			    return this.left.smaller(k) && this.right.smaller(k);	
			}
			/* 
			 * There is a key > k at the root of one of the Forks. Hence, return false.
			 */
			else {
				return false;
			}
		}
	}

	/**
	 * Does every node have it's key bigger than k?
	 * 
	 * @return Whether or not all keys are higher than k.
	 * @param k The value that we are checking whether or not all keys are bigger than.
	 */
	@Override
	public boolean bigger(Comparable k) {
		/* CASE : BOTH BRANCHES ARE EMPTY
		 * 
		 * If both branches are empty, we're at the bottom of the BST.
		 */
		if(this.left instanceof Empty) {
			if(this.right instanceof Empty) {
				return true; // We are at the bottom of the branch and there are no conflicts.
			}
			/* CASE : THE LEFT BRANCH IS EMPTY BUT THE RIGHT BRANCH IS NOT
			 * 
			 * If the root value of the right Fork is greater
			 * than k, return the value of bigger on the
			 * right fork.
			 * 
			 * We can cast this.right to a Fork safely, because we know that it isn't Empty, 
			 * and it can only be either Empty or a Fork.
			 */
			else if((k.compareTo(((Fork<K,V>)this.right).getRootKey())) < 0) {
				    return this.right.bigger(k);
				}
			    /* 
			     * There is a key < k at the root of the right Fork. Hence, return false.
			     */
			    else {
			    	return false;
		     	}
			}
	    /* CASE : THE RIGHT BRANCH IS EMPTY BUT THE LEFT BRANCH IS NOT
	     * 
	     * If the root value of the left Fork is greater
	     * than k, return the value of bigger on the
	     * left fork. (If the right Fork is Empty). 
	     */
		else if(this.right instanceof Empty) {
			if((k.compareTo(((Fork<K,V>)this.left).getRootKey())) < 0) {
			    return this.left.bigger(k);
			}
			/* 
			 * There is a key < k at the root of the left Fork. Hence, return false.
			 */
			else {
				return false;
			}
		}
		/* CASE : NEIHER BRANCH IS EMPTY
		 * 
		 * If the root value of both Forks is greater
		 * than k, return the value of bigger on the
		 * left fork and then right fork.
		 */
		else {
			if(((k.compareTo(((Fork<K,V>)this.left).getRootKey())) < 0) && ((k.compareTo(((Fork<K,V>)this.right).getRootKey())) < 0)) {
			    return this.left.bigger(k) && this.right.bigger(k);	
			}
			/* 
			 * There is a key < k at the root of one of the Forks. Hence, return false.
			 */
			else {
				return false;
			}
		}
	}

	/**
	 * Does the key, k, occur in this tree?
	 *
	 * @return Whether or not the key, k, occurs in the tree.
	 * @param k The key to search for.
	 */
	@Override
	public boolean has(Comparable k) {
		if(this.right instanceof Empty) {
			if(this.left instanceof Empty) {
				/* CASE : BOTH BRANCHES ARE EMPTY.
				 * 
				 * If both branches are empty, return whether or not the root is 
				 * equal to k.
				 */
				return (k.compareTo(this.getRootKey()) == 0);
			}
			/* CASE : THE RIGHT BRANCH IS EMPTY BUT THE LEFT BRANCH IS NOT.
			 * 
			 * If the right branch is Empty but the left branch is not,
			 * return whether or not the root is equal to k, and the 
			 * result of has() on the left branch.
			 */
			return (k.compareTo(this.getRootKey()) == 0) && this.left.has(k);
		}
		else if(this.left instanceof Empty) { 
		    /* CASE : THE LEFT BRANCH IS EMPTY BUT THE RIGHT BRANCH IS NOT.
		     * 
		     * If the left branch is Empty but the right branch is not,
		     * return whether or not the root is equal to k, and the
		     * result of has() on the right branch.
		     */
			return (k.compareTo(this.getRootKey()) == 0) && this.right.has(k);
		}
	    else {
		    /* CASE : NEITHER BRANCH IS EMPTY
		     * 
		     *  If neither branch is Empty, return whether or not the root is
		     *  equal to k, and the result of has() on both branches.
		     */
		    return (k.compareTo(this.getRootKey()) == 0) && this.left.has(k) && this.right.has(k);
	    }
	}

	/**
	 * Finds the value of the node with a given key, k, if it exists,
	 * and otherwise returns an empty instance of the Optional class.
	 * 
	 * @return The value of the node with key, k, or Optional.empty() if no such key exists.
	 * @param k The key to search for the value of.
	 */
	@Override
	public Optional find(Comparable k) {
        if(this.right instanceof Empty) {
        	if(this.left instanceof Empty) {
				/* CASE : BOTH BRANCHES ARE EMPTY
		         * 
		         * If both branches are empty and we haven't found k, return 
		         * Optional.empty() because k isn't in the tree.
		         */
        		return Optional.empty();
        	}
        	/*
        	 * CASE : THE RIGHT BRANCH IS EMPTY BUT THE LEFT BRANCH IS NOT
        	 * 
        	 * If the right branch is empty but the left branch is not, if the 
        	 * root key is equal to k, return the root node, otherwise return
        	 * find() on the left branch. 
        	 */
        	if(k.compareTo(this.getRootKey()) == 0) {
        		return Optional.of(this.root);
        	}
        	else {
        		return this.left.find(k);
        	}
        }
        else if(this.left instanceof Empty) {
        	/* CASE : THE LEFT BRANCH IS EMPTY BUT THE RIGHT BRANCH IS NOT
        	 * 
        	 * If the left branch is empty but the right branch is not, if the
        	 * root key is equal to k, return the root node, otherwise return 
        	 * find() on the right branch.
        	 */
        	if(k.compareTo(this.getRootKey()) == 0) {
        		return Optional.of(this.root);
        	}
        	else {
        		return this.right.find(k);
        	}
        }
        else {
        	/* CASE : NEITHER BRANCH IS EMPTY
        	 * 
        	 * If neither branch is empty, if the root key is equal to k, return
        	 * the root node, otherwise return find on both branches.
        	 */
        	if(k.compareTo(this.getRootKey()) == 0) {
        		return Optional.of(this.root);
        	}
        	else {
        		/*
        		 * Imagine this like : this.right.find(k) && this.left.find(k);
        		 */
        		if(this.right.find(k) == Optional.empty()) {
        		    return this.left.find(k);
        		}
        		return this.right.find(k);
        	}
        }
	}

	/**
	 * Returns a copy of this tree with a new Entry consisting of the
	 * key:value pair, k:v, inserted if the key isn't already there,
	 * or with the value replaced, if it is already there.
	 * 
	 * @return A copy of this tree with the new key:value pair, k:v, inserted.
	 * @param k The key for the key:value pair.
	 * @param v The value for the key:value pair.
	 * 
	 * "PSEUDOCODE" : 
	 *    If k is equal to the value of the root : replace the current node with new Entry<K,V>(k,v)
	 *    If k is smaller than the value of the root : insert k into the left branch
	 *    If k is larger than the value of the root : insert k into the right branch 
	 */
	@Override
	public Bst put(Comparable k, Object v) {
		    if(this.left instanceof Empty && this.right instanceof Empty) {
		    	return new Fork<K,V>(new Entry(k,v), new Empty(), new Empty());
		    } 
		    if(k.compareTo(this.getRootKey()) == 0) {
		    	return new Fork<K,V>(new Entry(k,v), this.left, this.right);
		    }
		    else if(k.compareTo(this.getRootKey()) < 0) {
		        return new Fork<K,V>(this.root, this.left.put(k,v), this.right);
		    }
		    else if(k.compareTo(this.getRootKey()) > 0) {
		        return new Fork<K,V>(this.root, this.left, this.right.put(k,v));
		    }
		    //This will never be reached.
		    return new Fork<K,V>(this.root, this.left, this.right);
		}

	/**
	 * Returns a copy of the tree, in which the node k has been deleted,
	 * or Optional.empty() if the key k doesn't occur in the tree.
	 * 
	 * @return A copy of this tree with the Entry with key, k, deleted, or optional.Empty() if no such key exists.
	 * @param k The key to delete from the tree.
	 */
	@Override
	public Optional delete(Comparable k) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the entry with the smallest key (left-most node), if it exists.
	 * 
	 * @return The Entry with the smallest key, if it exists.
	 */
	@Override
	public Optional smallest() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns a new tree with the element with the smallest key deleted, if it exists.
	 * 
	 * @return A new tree with the smallest key deleted, or Optional.empty() if it doesn't exist.
	 */
	@Override
	public Optional deleteSmallest() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Returns the entry with the largest key (right-most node), if it exists.
	 * 
	 * @return The Entry with the largest key, if it exists.
	 */
	@Override
	public Optional largest() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns a new tree with the element with the largest key deleted, if it exists.
	 * 
	 * @return A new tree with the largest key deleted, or Optional.empty() if it doesn't exist.
	 */
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
	public Bst<K,V> balanced() {
		// TODO Auto-generated method stub
		return null;
	}

}
