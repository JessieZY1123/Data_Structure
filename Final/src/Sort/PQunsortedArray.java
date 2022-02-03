package Sort;
/*
 * 	   public void add(K x) throws Exception;
	   public K removeMin() throws Exception;
	   public boolean isEmpty();
	   插入简单，删除的时候排序
 */

import java.util.Arrays;

public class PQunsortedArray < K extends Comparable<K> >implements PriorityQueue<K>{
	K[] data;
	int size;
	int capacity;
	
	@SuppressWarnings("unchecked")
	public PQunsortedArray() {
		capacity =100;
		size =0;
		data =(K[])new Comparable[capacity];
	}
	public PQunsortedArray(int c) {
		capacity=c;
		size=0;
		data = (K[]) new Comparable[capacity];
	}
	//easy insertion 
	public void add(K x) throws Exception{
		if(size>=capacity) throw new Exception("Queue full");
		data[size++] =x;
	}
	/*假设最小值为data[0]
	 * 
	 */
	public K removeMin() throws Exception{
		if (size==0) 
			throw new Exception("Queue Empty");
		int minIndex =0;
		for(int i=1; i<size; i++) {
			if(data[i].compareTo(data[minIndex])<0) 
				minIndex = i;}
		K ans = data[minIndex];
		//是把数据前移
		for(int i = minIndex +1; i< size; i++) {
			data[i-1] =data[i];			
		}
		size--;
		return ans;
		}
	
	public K removeMax() throws Exception{
		if (size==0) 
			throw new Exception("Queue Empty");
		int maxIndex =0;
		for(int i=1; i<size; i++) {
			if(data[i].compareTo(data[maxIndex])>0) 
				maxIndex = i;}
		K ans = data[maxIndex];
		//是把数据前移
		for(int i = maxIndex +1; i< size; i++) {
			data[i-1] =data[i];			
		}
		size--;
		return ans;
		}
	public boolean isEmpty() {
		return size ==0;
	}
	public  String toString( PQunsortedArray<Integer> a ) {
		 
        String str = new String();
        str = Arrays.toString(a.data);
        return str;
    }

	
	public static void main(String[] args) throws Exception  {
		PQunsortedArray<Integer> arr = new PQunsortedArray<Integer>(6);
		arr.add(6);
		arr.add(5);
		arr.add(7);
		arr.add(1);
		arr.add(2);
	
		System.out.println("Unsorted array is"+ arr.toString(arr));
		System.out.println(arr.size);
		//arr.removeMin();
		arr.removeMax();
		System.out.println("Remove array is"+ arr.toString(arr));
		System.out.println(arr.size);
	
}
	}
