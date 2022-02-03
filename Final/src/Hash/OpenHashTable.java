package Hash;

import java.util.ArrayList;
import java.util.Iterator;
/*
 * 
 */
public class OpenHashTable<E>implements Set<E> {
	int size;
    int capacity;
    E seats[];
    E ghost; //Marks departed entries in the table 在表中标记离开的数据
    
    OpenHashTable(int capacity,  E ghostEntry){
    	this.ghost = ghostEntry;
    	this.capacity = capacity;
    	seats = (E[]) new Object[capacity];
    	size =0;
    	for(int i =0; i< capacity; i++) {
    		seats[i]=null;
    		}
    }
    OpenHashTable(E ghostEntry){
    	this(1000, ghostEntry);
    }
    public boolean contains(E k) {
        return locate(k) != -1;  //locate finds the index k in the table
    }
    
    //Hashing and collision in linear probing 线性探查中的哈希和碰撞
    //查找K的位置 ，如果没有，就返回-1
    private int locate(E k) {
    	int h  = k.hashCode() % capacity;
    	int step = 0;
    	while(step < capacity) {
    		int index = resolve(h,step);
    		if(seats[index]==null) return -1;
    		if(k != ghost && k.equals(seats[index]))
    			return index;
    		step++;
    	}
    	return -1; 
    }
  //linear probing for collision resolution 解决碰撞的线性探测
	private int resolve(int h, int step) {
		return (h + step) % capacity;  //向右移
	}
	
	//返回可以放 k 的位置， 如果找不到，就返回-1
	private int findSpace(E k) {   //Finds the next available seat for k
		
		int h = k.hashCode() % capacity;
		int step = 0;
		while (step<capacity) {
			int index = resolve(h,step);
			if(seats[index]==null) return index;
			if(seats[index]==ghost) return index;
			step++;
		}
		return -1; //位置已经满了
	}
	public E get(E k) {
        int i = locate(k); // i 是 k的 index
        if(i == -1) return null;
        return seats[i];
    }
	public void add(E k) throws Exception {
        int i = findSpace(k);  //Finds the next available seat for k
        if(i != -1) seats[i] = k;
        else 
            throw new Exception("Hash table is full!");
    }
	 public void remove(E k) {
	        int i = locate(k);
	        if(i == -1) return;
	        seats[i] = ghost;
	    }
	 
	 public void dumpData()  {
	        for (int i = 0; i < capacity; i++) {
	            if (seats[i] != null && seats[i] != ghost) {
	                System.out.println("" + i + ": " + seats[i].toString());
	            }
	        }
	    }
	    
	    public Iterator<E> iterator() {
	        ArrayList<E> content = new ArrayList<>();
	        for(int i =0; i < capacity; i++) {
	            if(seats[i] != null && seats[i] != ghost)
	                content.add(seats[i]);
	        }
	        return content.iterator();
	    }
	    
	    public int size() {
	        return size;
	    }
	    
	    public boolean isEmpty() {
	        return size == 0;
	    }
}
