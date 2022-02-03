package ItQueue;
/*
 * 用
 */
public class LinkedQueue<T> implements Queue<T>{
	
	  protected LinkedList<T> list;

	  /** Constructs an initially empty queue. */
	  public LinkedQueue() { 
		  list = new LinkedList<T>(); 
}

	  /**
	   * Returns the number of elements in the queue.
	   * @return number of elements in the queue
	   */
	  public int size() { return list.size(); }

	  /**
	   * Tests whether the queue is empty.
	   * @return true if the queue is empty, false otherwise
	   */
	  public boolean isEmpty() { return list.isEmpty(); }

	  /**
	   * Inserts an element at the rear of the queue.
	   * @param element  the element to be inserted
	   */
	  public void enqueue(T e) { 
		  list.addTail(e); }

	  /**
	   * Returns, but does not remove, the first element of the queue.
	   * @return the first element of the queue (or null if empty)
	   */
	  public T first() { 
		  return list.head(); }

	  /**
	   * Removes and returns the first element of the queue.
	   * @return element removed (or null if empty)
	   */
	  public T dequeue() { 
		  return list.removeHead(); }

	  /** Produces a string representation of the contents of the queue.
	   *  (from front to back). This exists for debugging purposes only.
	   */
	  public String toString() {
	    return list.toString();
	  }

	  public static void main(String [] args){
	    Queue<String> q = new LinkedQueue<>();
	    q.enqueue("z");
	    q.enqueue("y");
	    q.dequeue();
	    System.out.println(q.toString());
	  }
}
	