/*
 * SetAdapterMap<K, V> 实例化Map接口；
 * 	 public int size();
	 public boolean isEmpty();
	 public V get(K k);
	 public void put(K k, V v)  throws Exception;
	 public void remove(K k) throws Exception;
	 public Set<K> keySet() throws Exception;
	 public void dumpTable();
 */
public class SetAdapterMap<K, V> implements Map<K,V>{
	protected Set<Entry<K,V>> table;    //table 是一个set类型，set中以map的数据形式存储. table有set的方法
	 
	public SetAdapterMap(Set<Entry<K, V>> s) {
	        table = s;
	    }
	    
	public int size() {
		return table.size();
	}
	public boolean isEmpty() {
		return table.isEmpty();
	}
	// return the value of key.
	public V get(K k) {
		try {
			Entry<K,V> entry = new Entry<K,V>(k,null);
		return table.get(entry).getValue();
	}catch(Exception e) {
		return null;
		}
	}
	public void put(K k,V v) throws Exception{
		table.add(new Entry<K,V>(k,v));
	}
	public void remove(K k) throws Exception{
		table.remove(new Entry<K,V>(k, null));
	}
	public Set<K> keySet() throws Exception{
		Set<K> answer = new ChainedHashTable<K>(size());
		for(Entry<K,V> e : table) {
			answer.add(e.getKey());
		}
		return answer;    //返回key的集合
	}
	public void dumpTable() {
		table.dumpData();
	}
}
