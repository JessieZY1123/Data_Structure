import java.util.ArrayList;
import java.util.Iterator;

/*
 * 	public int size();
	public boolean isEmpty();
	public boolean contains(E k);
	public E get(E k);
	public void add(E k) throws Exception;
	public void remove(E k) throws Exception;
	public Iterator<E> iterator();
	public void dumpData();
 */
public class OpenHashTable<E> implements Set<E>{
	int size;
	int capacity;
	E seats[];
	E ghost; //记录删除的entries
	
	OpenHashTable(int cap, E ghostEntry) {
        this.ghost = ghostEntry;
        capacity = cap;
        seats = (E[]) new Object[cap];
        size = 0;
        for(int i = 0; i < cap; i++)
            seats[i] = null;
    }
	OpenHashTable(E ghostEntry) {
        this(1000, ghostEntry);
    }
	//Hashing and collision in linear probing
	private int locate(E k) {
		int h = k.hashCode() % capacity;
		int step =0;
		while(step<capacity) {
			int index = resolve(h, step);
			if(seats[index]==null) return -1;
			if(k!=ghost && k.equals(seats[index]))
				return index;
			step++;
		}
		return -1;
	}
	//linear probing for collision resolution
	private int resolve(int h, int step) {
		return (h+step)% capacity;
	}
	
	private int findSpace(E k) {
		int h = k.hashCode()%capacity;
		int step=0;
		while(step<capacity) {
			int index =resolve(h,step);
			if(seats[index]== null) return index;
			if(seats[index]== ghost) return index;
			step++;
		}
		return -1;
	}
	
	
	public boolean contains(E k) {
		return locate(k)!=-1; //locate finds the index k in the table
	}
	public E get(E k) {
		int i= locate(k);
		if(i==-1) return null;
		return seats[i];
	}
	public void add(E k) throws Exception{
		int i = findSpace(k);//Finds the next available seat for k
		if(i !=-1) seats[i]=k;
		else
			throw new Exception("Hash table is full");
	}
	public void remove(E k) {
		int i =locate(k);
		if(i==-1) return;
		seats[i]=ghost;
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
