import java.util.LinkedList;

public class LinkedQueue<T> implements Queue<T> {
	private LinkedList<T> list;
	public LinkedQueue() {
		list = new LinkedList<T>();
	}
	public int size() {
		return list.size();
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public void enqueue(T e) {
		list.addLast(e);//addTail();
	}
	public T dequeue() {
		return list.removeFirst();
	}
	public T first() {
		return list.getFirst();
	}
	public String toString() {
		return list.toString();
	}
	public static void main(String[] args) {
		Queue<String> queue=new LinkedQueue<>();
		queue.enqueue("z");
		queue.enqueue("y");
		queue.dequeue();
		System.out.println(queue.toString());
	}
}
