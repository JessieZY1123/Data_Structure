package PriorityQueue;
import java.util.Iterator;
import java.util.ArrayList;
/*
 * Implement the class MaxHeapPQ that implements the interface MaxPriorityQueue using the maximum-oriented heap. 
 * The heap order in a maximum-oriented heap: the key in each node is larger than or equal to the keys in that node's two children, if any. 
 * Add a method min() to find the minimal key of a maximum-oriented heap priority queue.
 * @author - ZIYAN JIANG
 */
class MaxHeapPQ<K extends Comparable<K>> implements MaxPriorityQueue<K> {
   private K data[];
   private int size;
   private int capacity;
   private K findMin;

   // constructors
   public MaxHeapPQ() {
      capacity = 100;
      size = 0;
      data = (K[]) new Comparable[capacity];
   }

   public MaxHeapPQ(int c) {
      capacity = c;
      size = 0;
      data = (K[]) new Comparable[capacity];
   }

   // required priority queue methods
   public boolean isEmpty(){ return size==0; }

   public void add(K x) throws Exception {
	      if(size>=capacity-1)
	    	  throw new Exception("Priority Queue Full.");
	      data[size++] = x;    
	      bubbleUp(size - 1);  
	     
	      K firstLeaf = data[size/2];
	      findMin = firstLeaf;
	      for(int i=size/2;i<size;i++) {
	    	  if(data[i].compareTo(findMin)<0)
	    		  findMin = data[i];
	      }
	   
	   }
//   public void add(K x) throws Exception {
//	      if (size >= capacity - 1)
//	         throw new Exception("Priority Queue Full");
//	      if (minimum == null || x.compareTo(minimum) <= 0) minimum = x;
//	      data[size++] = x;
//	      bubbleUp(size - 1);
//	   }


   public K removeMax() throws Exception {
      if (size <= 0)
         throw new Exception("Priority Queue Empty");
     swapData(0,--size);
     bubbleDown(0);
     return data[size];
   }

   // auxiliary utility methods
   private void swapData(int n, int m) {
      K temp = data[n];
      data[n] = data[m];
      data[m] = temp;
   }

   private void bubbleUp(int n) {
      if (n <= 0)
         return; // at root
      K dn = data[n]; //child
      K dp = data[(n - 1) / 2]; // parent data
      if(dn.compareTo(dp)<=0) return; 
      swapData(n,(n-1)/2);
      bubbleUp((n-1)/2);
   }

   public void bubbleDown(int n) {
      if (2 * n + 1 >= size)
         return; // at leaf
      K dn = data[n]; //parent
      K dl = data[2 * n + 1]; // left child
      K dr = dl;
      if(2*n+2<size) {
    	  dr = data[2 * n + 2];
      }
      if(dn.compareTo(dr)>0 && dn.compareTo(dl)>0) return; //dn is greater then its leftChild and rightChild.
      if(dr.compareTo(dl)>0) { //if rightChild is greater than leftChild, swap rightChild and parent
    	  swapData(n,2*n+2);
    	  bubbleDown(2*n+2);
      }else { 
    	  swapData(n,2*n+1);
    	  bubbleDown(2*n+1);
      }
   }

   // heap creation
   public void heapify(Iterator<K> x) throws Exception {
      while (x.hasNext()) {
         if (size + 1 == capacity)
            break;
         data[size++] = x.next();
      }
      int n = size / 2;
      while (--n >= 0)
         bubbleDown(n);
      if (x.hasNext())
         throw new Exception("Heap is Full");
   }
   
   /* Add a min() method to find the minimum. Your implementation should use constant time and constant extra space.
    * Hint: add an extra instance variable that points to the minimum item. Update it after each call to add(K x).
    * Return null if the heap is empty.
    */
   public K min(){
	   if(size==0) return null;
	   return findMin;
   }

   public static void main(String[] args){
	   MaxHeapPQ<String> heap = new MaxHeapPQ<String>();
	   try{
	   	heap.add("q");
	   	heap.add("w");
	   	heap.add("e");
	   	heap.add("r");
	   	heap.add("t");
	   	heap.add("y");
	   	
		System.out.println(heap.min()); // the output would be e	
		while (!heap.isEmpty()) System.out.print(heap.removeMax()); // the printout would be ywtrqe
		System.out.println();
	   } catch (Exception e){System.out.println("Error " + e.toString()); }

   }
}

interface MaxPriorityQueue<K extends Comparable<K>> {
   public void add(K x) throws Exception;
   public K removeMax() throws Exception;
   public boolean isEmpty();
}