package DStackToQueue;

import java.util.Stack;

/*
 * void enqueue(T e);
	T dequeue();
	int size();
	boolean isEmpty();
	T first();//return but not remove the first of queue
}
 */

public class StackQueue<T> implements queue<T>{
	private Stack<T> inStack;
	private Stack<T> outStack;
	int size;
	
	public StackQueue() {
		inStack = new Stack<T>();
		outStack = new Stack<T>();
		size=0;
		
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void enqueue(T data) {
		inStack.pop();
		size++;
	}
	public T dequeue() {
		if(size==0) return  null;
		if(outStack.isEmpty()) {
			while(!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
			size--;
		}return outStack.pop();
	}
	public T first() {
		if(isEmpty()) return null;
		if(outStack.isEmpty()) {
			while(!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}return outStack.peek();
	}
}
