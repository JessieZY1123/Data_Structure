package Queue;

public class linkedQueue<T> implements queue<T> {
	private SingleLinkedList<T> list;
	
	public linkedQueue() {
		list = new SingleLinkedList<T>();
	}
	
	public int size() {
		return list.size;
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public void enqueue(T data) {
		list.addLast(data);
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
		queue<String> queue=new linkedQueue<>();
		queue.enqueue("z");
		queue.enqueue("y");
		queue.dequeue();
		System.out.println(queue.toString());
	}
}
