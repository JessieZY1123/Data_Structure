
public class ArrayQueue<T> implements Queue<T>{
	private T data[];
	private int front, rear, size, capacity;
	public ArrayQueue() {
		capacity = 1000;
		data = (T[])new Object[capacity];
		front =0;
		rear = 0;
		size = 0;
	}
	public ArrayQueue(int c) {
		capacity = c;
		data =(T[]) new Object[capacity];
		front = rear = size =0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size ==0;
	}
	public T first() {
		if(isEmpty()) return null;
		return data[front];
	} 
	public void enqueue(T x) throws IllegalStateException{
		if(size() ==capacity )
			throw new IllegalStateException("Queue is full");
		data[rear]=x;
		rear++;
		//data[rear++] = x;
		if(rear == capacity) rear =0;
		size++;
	}
	public T dequeue() {
		if(isEmpty())return null;
		T ans = data[front++];// T ans = data[front],and then front++
		if(front== capacity) front = 0;
		size--;
		return ans;
	}
    public String toString() {
        String ans = "ArrayQueue: ";
	if (isEmpty()) return null;
	if (front >= rear){
		for (int i = front; i < capacity-1; i++)
			ans += (data[i] + " -> ");
		if (rear == 0) ans += data[capacity-1];
		if (rear > 0){
			ans += (data[capacity-1] + " -> ");
			for (int i = 0; i < rear-1; i++)
				ans += (data[i] + " -> ");
			ans += data[rear-1];
		}
	}else{
		for (int i = front; i < rear-1; i++)
			ans += (data[i] + " -> ");
		ans += data[rear-1];
	}

        return ans;
    }
    
    public static void main(String[] args) {
        Queue<String> q = new ArrayQueue<String>(3);
        q.enqueue("t");
        q.enqueue("u");
        q.enqueue("v");
	System.out.println(q.toString()); // t -> u -> v
        q.dequeue();
	q.dequeue();
	System.out.println(q.toString()); // v
	q.enqueue("t");
        System.out.println(q.toString()); // v -> t
	q.dequeue();
	System.out.println(q.toString()); // t
    }
}
