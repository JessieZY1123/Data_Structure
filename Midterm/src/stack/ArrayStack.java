package stack;
/*
 * Main idea:
 * There is a top to store the index! of stack top. 相当于一个指针
 * There is an array to store the data. No arraylist.
 */
public class ArrayStack<T> implements Stack<T>{
	private int top;
	private T[] arrayStack;
	
	public ArrayStack() {
		arrayStack =(T[]) new Object[1000];
		top=-1;
	}
	public int size() {
		return top+1;
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public void push(T data) throws IllegalStateException{
		if(size()==1000)
			throw new IllegalStateException("Stack is full");
		top=top+1;   // index of the stack
		arrayStack[top]=data;
	}
	
	public T top() {
		if(isEmpty()) return null;
		return arrayStack[top];
	}
	
	public T pop() {
		if(isEmpty()) return null;
		return arrayStack[top--];//先return，在top后移
	}
}
