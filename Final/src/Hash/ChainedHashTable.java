package Hash;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * public interface Set<E> extends Iterable<E> {
	public int size();
    
    public boolean isEmpty();
    
    public boolean contains(E k);
    
    public E get(E k);
    
    public void add(E k) throws Exception;
    
    public void remove(E k) throws Exception;
    
    public Iterator<E> iterator();
    
    public void dumpData();

}
 */
public class ChainedHashTable<E> implements Set<E>{
	int size;
	int capacity;
	ArrayList<E> bucket[];
	// constructor of ChainedHashTable
	public ChainedHashTable (int capacity) {
		this.capacity = capacity;
		bucket = (ArrayList<E>[]) new ArrayList[capacity];
		size =0; //the size of bucket[i]
		for(int i =0; i< capacity; i++) {
			bucket[i] = null;
		}
	}
	
	ChainedHashTable(){
		this(1000);
	}
	public int size() {
		return size;
	} 
	public boolean isEmpty() {
		return size==0;
	}
	public E get(E k) {
		int h = k.hashCode()% capacity; //得到末尾的数值
		if(bucket[h]!=null) { //如果bucket[h] 不为空， 也就是bucket[h]中有
			for(int i =0; i<bucket[h].size();i++) {  //在bucket[h]中一个一个的找
				E p = bucket[h].get(i);
				if(p.equals(k)) {
					return p;
				}
			}
		}return null;
	}
	public boolean contains(E k) {
		return get(k) != null;
	}
	public void add(E k) {
		int h = k.hashCode()% capacity;
		if(bucket[h]==null) 
			bucket[h] = new ArrayList<>();
		for(int i=0; i< bucket[h].size();i++) {
			E p = bucket[h].get(i);
			if(p.equals(k)) {
				bucket[h].set(i, k); //如果相同，替换为k，其实是一样的
				return;
			}		
		}bucket[h].add(k);
		size++;
	}
	public void remove(E k ) {
		int h = k.hashCode() % capacity;
		if(bucket[h]!= null) {
			for(int i = 0;i<bucket[h].size();i++ ) {
				E p = bucket[h].get(i);
				if(p.equals(k)) {
					bucket[h].remove(i);
					size--;
					return;
				}
			}
		}
	}
	public void dumpData() {
		for(int i = 0; i< capacity; i++) {
			if(bucket[i]!=null) {
				System.out.print("" + i + ": ");
				for(int j =0; j<bucket[i].size();j++) {
					E p = bucket[i].get(j);
					System.out.print(p);
					if (j < bucket[i].size() -1) System.out.print(", ");
				}
				 System.out.println();
			}
		}
	}
	
	public Iterator<E> iterator(){
		ArrayList<E> content = new ArrayList<E>();
        for (int i =0; i < capacity; i++) {
            if( bucket[i] != null) {
                for (int j = 0; j < bucket[i].size(); j++)
                    content.add(bucket[i].get(j));
            }
        }
        return content.iterator();
    }
	
}
