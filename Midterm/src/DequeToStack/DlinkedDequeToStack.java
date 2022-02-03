package DequeToStack;
/*
 * 头加头减就行。
 */

public class DlinkedDequeToStack<T> implements Stack<T>{
	private DlinkedDeque<T> Dlist;
	
	public DlinkedDequeToStack() {
		Dlist = new DlinkedDeque<>();
	}
	 public int size() {
		 return Dlist.size();
	 }
	 public boolean isEmpty() {
		 return Dlist.isEmpty();
	 }
	 public void push(T data) {
		 Dlist.addFirst(data);
	 }
	 public T top() {
		 if(isEmpty())return null;
		 return Dlist.first();
	 }
	 public T pop() {
		 if(isEmpty()) return null;
		 return Dlist.removeFirst();
	 }
	 public String toString() {
		 return Dlist.toString();
	 }
	 public static void main(String[] args) {
		 Stack<String> QStack =  new DlinkedDequeToStack<String>();
		 QStack.push("A");
		 QStack.push("B");
		 QStack.push("C");
		 System.out.println(QStack.top());
		 System.out.println(QStack.toString());
		 QStack.pop();
		 System.out.println(QStack.toString());
	 }
}
