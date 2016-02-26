import java.util.Optional;

public class Fork<K extends Comparable<K>,V> implements Bst<K,V> {

	private final Entry<K,V> root;
	private final Bst<K,V> left, right;
	
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
	
	public K getRootKey() {
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
	public boolean smaller(K k) {
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
	public boolean bigger(K k) {
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
	public boolean has(K k) {
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
	public Optional<V> find(K k) {
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
        		return Optional.of(this.root.getValue());
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
        		return Optional.of(this.root.getValue());
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
        		return Optional.of(this.root.getValue());
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
	 *     >> If k is equal to the value of the root : replace the current node with new Entry<K,V>(k,v)
	 *     >> If k is smaller than the value of the root : insert k into the left branch
	 *     >> If k is larger than the value of the root : insert k into the right branch 
	 */
	@Override
	public Bst<K,V> put(K k, V v) {
	         /*
	          * If both branches are empty, make a comparison based on the root node,
	          * and create a new Fork with the root, another new Fork (with a new 
	          * Entry as it's root) to it's respective side.
	          */
		     if(this.left instanceof Empty && this.right instanceof Empty) {
		    	 /* 
		    	  * If k is equal to the key of the root node, return a new Fork 
		    	  * consisting of the new Entry, and two Empty branches.
		    	  */
		    	 if(k.compareTo(this.getRootKey()) == 0) {
		    		 return new Fork<K,V>(new Entry<K,V>(k,v), new Empty<K,V>(), new Empty<K,V>());
		    	 }
		    	 /*
		    	  * If k is less than the key of the root node, return a new Fork 
		    	  * consisting of the current root node, a new fork consisting of
		    	  * the new Entry as it's root and two Empty branches, and an 
		    	  * Empty branch.
		    	  */
		         else if(k.compareTo(this.getRootKey()) < 0) {
	            	 return new Fork<K,V>(this.root, new Fork<K,V>(new Entry<K,V>(k,v), new Empty<K,V>(), new Empty<K,V>()), this.right);
	             }
		    	 /*
		    	  * If k is greater than the key of the root node, return a new Fork 
		    	  * consisting of the current root node, an Empty branch and a new fork 
		    	  * consisting of the new Entry as it's root and two Empty branches, 
		    	  */	    	 
	             return new Fork<K,V>(this.root, this.left, new Fork<K,V>(new Entry<K,V>(k,v), new Empty<K,V>(), new Empty<K,V>()));
	         }
		     /*
		      * We aren't at the bottom of the tree, so these cases will require recursive
		      * building of trees.
		      * 
		      * If k is equal to the value of the current key, return a new Fork consisting
		      * of the new Entry as a root, with the current left and right branches as 
		      * branches. 
		      */
		     else if(k.compareTo(this.getRootKey()) == 0) {
		    	 return new Fork<K,V>(new Entry<K,V>(k,v), this.left, this.right);
		     }
		     /*
		      * If k is less than the value of the current key, return a new Fork consisting
		      * of the current root and the result of put() on the left branch, and the current
		      * right branch as branches.
		      */
		     else if(k.compareTo(this.getRootKey()) < 0) {
		    	 return new Fork<K,V>(this.root, this.left.put(k,v), this.right);
		     }
		     /*
		      * If k is greater than the value of the current key, return a new Fork consisting
		      * of the current root and the current left branch and the result of put() on the
		      * right branch as branches.
		      */
		     else if(k.compareTo(this.getRootKey()) > 0) {
		    	 return new Fork<K,V>(this.root, this.left, this.right.put(k,v));
		     }
		     /*
		      * This will never have been reached, but it needs to be here because the method
		      * needs to always have the return type Bst.
		      */
		     return this;
		}

	/**
	 * Returns a copy of the tree, in which the node k has been deleted,
	 * or Optional.empty() if the key k doesn't occur in the tree.
	 * 
	 * @return A copy of this tree with the Entry with key, k, deleted, or optional.Empty() if no such key exists.
	 * @param k The key to delete from the tree.
	 */
	@Override
	public Optional<Bst<K,V>> delete(K k) {
		/*
		 * Once we get to the value that we need...
		 */
        if(k.compareTo(this.getRootKey()) == 0) {
        	/*
        	 * The left branch is empty, so just return the right branch,
        	 * assuming that it's there.
        	 */
        	if(this.left instanceof Empty) {
        		return Optional.of(this.right);
        	}
        	/*
        	 * The right branch is empty, so just return the left branch,
        	 * assuming that it's there.
        	 */
        	else if(this.right instanceof Empty) {
        	    return Optional.of(this.left);
        	}
        	/*
        	 * Both branches are non-empty.
        	 */
            else {
        		return Optional.of(new Fork<K,V>(left.largest().get(), this.left.deleteLargest().get(), right));
            }
        }
        /*
         * Keep traversing the tree until we find the Entry that we want to
         * delete.
         */
        else {
        	/*
        	 * If k is less than the key of the current node, we need to delete(k) 
        	 * from the left branch. 
        	 */
            if(k.compareTo(this.getRootKey()) < 0) {
            	return Optional.of(new Fork<K,V>(root, this.left.delete(k).get(), this.right));
            }
            /*
             * If k is greater than the key of the current node, we need to delete(k)
             * from the right branch.
             */
            return Optional.of(new Fork<K,V>(root, this.left, this.right.delete(k).get()));
        }
	}

	/**
	 * Returns the entry with the smallest key (left-most node), if it exists.
	 * 
	 * @return The Entry with the smallest key, if it exists.
	 */
	@Override
	public Optional<Entry<K,V>> smallest() {
		/*
		 * If the left branch is empty, this is the leftmost node, so return it.
		 */
		if(this.left instanceof Empty) {
			return Optional.of(this.root);
		}
		/*
		 * If the left branch isn't empty, return the result of smallest() on the
		 * left branch.
		 */
		return this.left.smallest();
	}

	/**
	 * Returns a new tree with the element with the smallest key deleted, if it exists.
	 * 
	 * @return A new tree with the smallest key deleted, or Optional.empty() if it doesn't exist.
	 */
	@Override
	public Optional<Bst<K,V>> deleteSmallest() {
		/*
		 * This one's pretty self-explanatory. Find the node with the smallest key
		 * value, and delete it.
		 */
		return this.delete(this.smallest().get().getKey());
	}
	
	/**
	 * Returns the entry with the largest key (right-most node), if it exists.
	 * 
	 * @return The Entry with the largest key, if it exists.
	 */
	@Override
	public Optional<Entry<K,V>> largest() {
		/*
		 * If the right branch is empty, this is the rightmost node, so return it.
		 */
		if(this.right instanceof Empty) {
			return Optional.of(this.root);
		}
		/*
		 * If the right branch isn't empty, return the result of largest() on the
		 * right branch.
		 */
		return this.right.largest();
	}

	/**
	 * Returns a new tree with the element with the largest key deleted, if it exists.
	 * 
	 * @return A new tree with the largest key deleted, or Optional.empty() if it doesn't exist.
	 */
	@Override
	public Optional<Bst<K,V>> deleteLargest() {
		/*
		 * This one's pretty self-explanatory. Find the node with the largest key
		 * value, and delete it.
		 */
		return this.delete(this.largest().get().getKey());
	}

	/**
	 * @return fancyToString()
	 */
    public String toString() {
	    return this.fancyToString();
    }
    
    /**
     * 2-dimensional, rotated tree printing. Not marked. Use for debugging.
     * 
     * @return A 2D rotated depiction of the tree.
     */
    @Override
    public String fancyToString() {
        return "\n\n\n" + fancyToString(0) + "\n\n\n";
    }
    
    /**
     * Same as fancyToString() but starting at position, d.
     * 
     * @return A 2D rotated depiction of the tree, starting at position d.
     */
    @Override
    public String fancyToString(int d) { 
        int step = 4;  // depth step
        String l = left.fancyToString(d + step);
        String r = right.fancyToString(d + step);
        return r + spaces(d) + this.root + "\n" + l;
    }
    
    /**
     * Used in fancyToString(int depth).
     * @param n The number of spaces to create a String from..
     * @return A String consisting of n spaces.
     */
    private String spaces(int n) { // Helper method for the above:
        String s = "";
        for (int i = 0; i < n; i++) s = s + " ";
        return s;
    }
	 
    /**
     * Counts how many values are stored in the tree.
     * 
     * @return The number of nodes in the Bst.
     */
	@Override
	public int size() {
		/*
		 * Empty.size() = 0, .: We can just do this ^-^
		 */
		return 1 + left.size() + right.size();
	}

	/**
	 * Gives the height of this tree. The height of the empty tree is
	 * -1 by convention.
	 * 
	 * @return The height of the Bst.
	 */
	@Override
	public int height() {
		/*
		 * Calculate the height of each subtree and return the largest one, 
		 * plus one. Calculate the height by doing 1 + the height of the
		 * subtrees.
		 */
		int leftHeight = 1 + this.left.height();
		int rightHeight = 1 + this.right.height();
		
		/*
		 * Return the largest of the two subtrees (See : https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html)
		 */
		return (leftHeight > rightHeight) ? leftHeight : rightHeight;
	}

	/**
	 * Prints the values in key order (left then root then right).
	 */
	@Override
	public void printInOrder() {
		// TODO Auto-generated method stub	
	}

	/**
	 * Save entries in key order in the array a starting at 0, as in an
     *  in-order traversal (left, then root, then right).
	 */
	@Override
	public void saveInOrder(Entry<K,V>[] a) {
		// TODO Auto-generated method stub
	}

	/**
     * Same as saveInOrder() but starting at position i, and inform the 
     * caller what the next available position of the array is.
     * 
     * @param i the position to start printing from.
	 */
	@Override
	public int saveInOrder(Entry<K,V>[] a, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns a balanced copy of this tree which is a tree with 
	 * same key-value pairs but with minimal height.
	 */
	@Override
	public Bst<K,V> balanced() {
		// TODO Auto-generated method stub
		return null;
	}

}
