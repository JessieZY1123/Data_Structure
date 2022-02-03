
public class ArrayDeque<T> implements Deque<T>{
	private T data[];
	private int front, rear, size, capacity;

	@SuppressWarnings({"unchecked"})
	public ArrayDeque(){
		capacity = 1000;
		data = (T[]) new Object[capacity];
		front = size = 0;
		rear = 1;
	}
	@SuppressWarnings({"unchecked"})
	public ArrayDeque(int c){
		capacity = c;
		data = (T[]) new Object[capacity];
		front = size = 0;
		rear = 1;
	}

	public int size(){
		return size;
	}

	public  T first(){
		if (isEmpty()) return null;
		if (front==capacity-1) return data[0];
		return data[front+1];
	}

	public T last(){
		if (isEmpty()) return null;
		if (rear==0) return data[capacity-1];
		return data[rear-1];
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public void addFirst(T e){
		if (size == capacity) throw new IllegalStateException ("Deque is full");
		//add Java codes for this method
		data[front]=e;
		front=front-1;
		size++;
		if(front<0) front = capacity-1;
		System.out.println(front);
	}

	public void addLast(T e){
		if (size == capacity) throw new IllegalStateException ("Deque is full");
		data[rear++] = e;
		if (rear == capacity) rear = 0;
		size++;
	}

	public T removeFirst(){
		if (isEmpty()) return null;
		T answer = data[front++];
		if (front == capacity) front = 0;
		size--;
		return answer;
	}
	public T removeLast() {
		if(isEmpty()) return null;
		T last =  data[--rear];
		if(rear<0) rear = capacity-1;
		size--;
		return last;	
	}

	 public String toString() {
	        String ans = "ArrayQueue: ";
		if (isEmpty()) return null;
		if (front >= rear){
			for (int i = front+1; i < capacity-1; i++)
				ans += (data[i] + " -> ");
			if (rear == 0) ans += data[capacity-1];
			if (rear > 0){
				ans += (data[capacity-1] + " -> ");
				for (int i = 0; i < rear-1; i++)
					ans += (data[i] + " -> ");
				ans += data[rear-1];
			}
		}else{
			for (int i = front+1; i < rear-1; i++)
				ans += (data[i] + " -> ");
			ans += data[rear-1];
		}

	        return ans;
	    }
	    
	    public static void main(String[] args) {
	    	ArrayDeque<String> q = new  ArrayDeque<String>(10);
	        q.addLast("t");
	        q.addLast("u");
	        q.addLast("v");
		System.out.println(q.toString()); // t -> u -> v
	//        q.dequeue();	q.dequeue();
		q.addFirst("a");
		q.addFirst("b");
	        System.out.println(q.toString()); // v -> t
	        q.removeFirst();
	        System.out.println(q.toString()); 
	    }
}