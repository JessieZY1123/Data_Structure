package Hash;

import java.util.Iterator;

/*
 * Map{public int size();
    public boolean isEmpty();  
    public V get(K k);
    public void put(K k, V v)  throws Exception;    
    public void remove(K k) throws Exception;   
    //Returns a Set view of the keys contained in this map
    public Set<K> keySet() throws Exception; 
    public void dumpTable();
}
 	entrySet()	Returns a Set view of the mappings contained in this map
 	
 	public interface Set<E> extends Iterable<E> {
	public int size();   
    public boolean isEmpty();
    public boolean contains(E k);  
    public E get(E k);  
    public void add(E k) throws Exception;   
    public void remove(E k) throws Exception;  
    public Iterator<E> iterator();   
    public void dumpData();

 */
public class SetAdapterMap<K, V> implements Map<K,V> {
	protected Set<Entry<K,V>> table; //set 中存放的都是map
	
	public SetAdapterMap(Set<Entry<K,V>> s) {
		table = s;
	}
	
	public int size() {
		return table.size();
	}
	
	public boolean isEmpty() {
		return table.isEmpty();
	}
	
	public V get(K k) {
		try {
			Entry<K,V> entry = new Entry<K,V>(k,null);
			return table.get(entry).getValue();
		}catch(Exception e) {
			return null;
		}
	}
	
	public void put(K k, V v) throws Exception{
		table.add(new Entry<K,V>(k,v));
	}
	public void remove(K k) throws Exception{
		table.remove(new Entry<K,V>(k,null));
	}
	public Set<K> keySet() throws Exception{
		 Set<K> answer = new ChainedHashTable<K>(size());
	        for (Entry<K, V> e: table) 
	            answer.add(e.getKey());
	        return answer;
	}
	public void dumpTable() {
		table.dumpData();
	}
}
