package Sort;

import java.util.Arrays;

public class PQsortedArray <K extends Comparable<K>> implements PriorityQueue<K>{
	K[] data;
	int size;
	int capacity;
	
	public PQsortedArray() {
		capacity =100;
		size =0;
		data = (K[]) new Comparable[capacity];
	}
	public PQsortedArray(int c) {
		capacity =c;
		size =0;
		data = (K[]) new Comparable[capacity];
	}
	public boolean isEmpty() {
		   return size==0;
	   }
	//从大到小排列
	public void add(K x) throws Exception {
		if(size >= capacity) throw new Exception("Queue Full");
		int i =size ;  //i 是最后一个位置
		//最后一个值比x小，则交换
		while(i>0 && data[i-1].compareTo(x)<0) {
			data[i]=data[i-1]; //前一值给后一个
			i--;
		}
		data[i] =x;
		size++;
}
	public K removeMin() throws Exception {
        if(size == 0) throw new Exception("Queue Empty");
        return data[--size];
    }
	public  String toString( PQsortedArray<Integer> a ) {
		 
        String str = new String();
        str = Arrays.toString(a.data);
        return str;
    }

	public static void main(String[] args) throws Exception  {
		PQsortedArray<Integer> arr = new PQsortedArray<Integer>();
		arr.add(8);
		arr.add(7);
		arr.add(5);
		arr.add(4);
		arr.add(6);
	
		System.out.println("Unsorted array is"+ arr.toString(arr));
		System.out.println(arr.size);
		arr.removeMin();
		System.out.println("Remove array is"+ arr.toString(arr));
		System.out.println(arr.size);
}
}