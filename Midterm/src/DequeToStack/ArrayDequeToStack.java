package DequeToStack;

import Deque.ArrayDeque;

public class ArrayDequeToStack<T> implements Stack<T>{
	private ArrayDeque<T> Dlist;
	
	public ArrayDequeToStack() {
		Dlist = new ArrayDeque<T>();
	}
	 
	  public int size() {
		  return Dlist.size();
	  }

	 
	  public boolean isEmpty() {
		  return Dlist.isEmpty();
	  }

	 
	  public void push(T e) {
		  Dlist.addFirst(e);
	  }

	 
	   public T top() {
		  return Dlist.first();
	  }

	 public  T pop() {
		 return Dlist.last();
	 }	 
}
