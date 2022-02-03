package Queue;

public class ArrayQueue<T> implements queue<T>{
	private T[] arrayQueue;
	/*	front 是指向第一个数据的index。
	 * 	rear是 指向最后一个数组的index+1；
	 */
	private int front,rear, size, capacity;
	
	public ArrayQueue() {
		capacity =1000;
		size=0;
		front=0;
		rear=0;
		arrayQueue = (T[]) new Object[capacity];
	}
	public ArrayQueue(int c) {
		capacity = c;
		arrayQueue =(T[]) new Object[capacity];
		front = rear = size =0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void enqueue(T data) throws IllegalStateException{
		if(size() ==capacity)
			throw new IllegalStateException("This queue is full");
		arrayQueue[rear]=data;
		rear++;//指针后移
		if(rear==capacity) rear=0;
		size++;
	}
	//输出前面的element
	public T dequeue() {
		if(isEmpty())return null;
		T data = arrayQueue[front];
		front++;//指针后移
		if(front == capacity) front=0;
		size--;
		return data;
	}
	public T  first() {
		if(isEmpty())return null;
		return arrayQueue[front];
	}
	 public String toString() {
	        String ans = "ArrayQueue: ";
		if (isEmpty()) return null;
		if (front >= rear){
			for (int i = front; i < capacity-1; i++)
				ans += (arrayQueue[i] + " -> ");
			if (rear == 0) ans += arrayQueue[capacity-1];
			if (rear > 0){
				ans += (arrayQueue[capacity-1] + " -> ");
				for (int i = 0; i < rear-1; i++)
					ans += (arrayQueue[i] + " -> ");
				ans += arrayQueue[rear-1];
			}
		}else{
			for (int i = front; i < rear-1; i++)
				ans += (arrayQueue[i] + " -> ");
			ans += arrayQueue[rear-1];
		}

	        return ans;
	    }
	    
	    public static void main(String[] args) {
	    	 queue<String> q = new ArrayQueue<String>(3);
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
