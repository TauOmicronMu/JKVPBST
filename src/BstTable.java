import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class BstTable<K extends Comparable<K>,V> implements Table<K,V> {
	
	private Bst<K,V> table;
	
	/**
	 * Creates a new instance of the BstTable class. 
	 * 
	 * This sets this.table to a new instance of Empty. Once a
	 * K:V pair is added (using put), Empty will handle this and
	 * create a new Fork. 
	 * 
	 * This is more efficient than storing K:V pairs in an Array/
	 * ArrayList. For example, to search for a key, the complexity
	 * is O(log(n)) with this implementation, but O(n) with an
	 * ArrayList.
	 */
	public BstTable() {
		this.table = new Empty<K,V>();
	}
	
	/**
	 * Creates a new instance of the BstTable class with the given
	 * Bst<K,V>, tree, as it's table attribute.
	 * 
	 * @param tree A given Bst<K,V> to use as the table attribute.
	 */
	public BstTable(Bst<K,V> tree) {
		this.table = tree;
	}

	/**
	 * Returns whether or not the table contains an Entry with
	 * key, k.
	 * 
	 * @param k The key to check.
	 * @return Whether or not the table contains an Entry with key, k.
	 */
	@Override
	public boolean containsKey(K k) {
		return this.table.has(k);
	}

	/**
	 * Returns the Entry with key, k, if it exists, or Optional.empty()
	 * if it does not.
	 * 
	 * @param The key to search for (and return the Entry of, should it exist).
	 * @return The Entry with key, k, or Optional.empty() if there is no Entry with key, k.
	 */
	@Override
	public Optional<V> get(K k) {
		return this.table.find(k);
	}

	/**
	 * Returns whether or not the current table is empty.
	 * 
	 * @return Whether or not the current table is empty.
	 */
	@Override
	public boolean isEmpty() {
		return this.table.isEmpty();
	}

	/**
	 * Returns a new table, which has another Entry added in, using the 
	 * key:value pair, k:v.
	 * 
	 * @param k The key for the key:value pair.
	 * @param v The value for the key:value pair.
	 * 
	 * @return A new instance of the Table class with the new Entry added.
	 */
	@Override
	public Table<K,V> put(K k, V v) {
        return new BstTable<K,V>(this.table.put(k,v));
	}

    /**
     * Returns a new table, but with the Entry with key, k, removed, if it exists.
     * If there is no Entry with key, k, return Optional.empty() instead. 
     * 
     * @param k the key of the Entry to remove.
     * 
     * @return A new instance of the Table class with the Entry with key k removed, or Optional.empty if there was no Entry with key, k.
     */
	@Override
	public Optional<Table<K,V>> remove(K k) {
		/*
		 * If the Bst contains k, then return a new BstTable containing a new tree, which is equal to the result
		 * of delete(k) on the current tree, otherwise, return Optional.empty().
		 */
	    return (this.table.has(k)) ? Optional.of((new BstTable<K,V>(this.table.delete(k).get()))) : (Optional.empty());
	}

	/**
	 * Returns the size of the table.
	 * 
	 * @return The size of the table.
	 */
	@Override
	public int size() {
		return this.table.size();
	}

	/**
	 * Return an Array of all of the values in the table.
	 * 
	 * @return An Array containing all values in the table.
	 */
	@Override
	public Collection<V> values() {
		/*
		 * Invoke an Array of Entries, using the ancient Goodman ritual.
		 */
		Object[] a = new Object[this.size()];
	    @SuppressWarnings("unchecked")
	    Entry<K,V>[] entries = (Entry<K,V>[]) a;
	    /*
	     * Save all of the Entries from the table 
	     */
	    this.table.saveInOrder(entries); 
	    /*
	     * Create a new ArrayList of values to hold the values, and 
	     * populate it with all of the values.
	     */
	    ArrayList<V> values = new ArrayList<V>();
	    for(Entry<K,V> e : entries) values.add(e.getValue());
	    
	    return values;
	}

	/**
	 * Return an Array of all the keys in the table.
	 * 
	 * @return An Array containing all keys in the table.
	 */
	@Override
	public Collection<K> keys() {
		/*
		 * Invoke an Array of Entries, using the ancient Goodman ritual.
		 */
		Object[] a = new Object[this.size()];
	    @SuppressWarnings("unchecked")
	    Entry<K,V>[] entries = (Entry<K,V>[]) a;
	    /*
	     * Save all of the Entries from the table 
	     */
	    this.table.saveInOrder(entries); 
	    /*
	     * Create a new ArrayList of keys to hold the values, and 
	     * populate it with all of the keys.
	     */
	    ArrayList<K> keys = new ArrayList<K>();
	    for(Entry<K,V> e : entries) keys.add(e.getKey());
	    
	    return keys;
	}
}
