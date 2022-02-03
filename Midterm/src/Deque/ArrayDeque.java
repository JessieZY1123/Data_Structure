package Deque;


public class ArrayDeque<T> implements Deque<T>{
	private T[] arrayDeque;
	int front, rear, size, capacity;
	
	public ArrayDeque() {
		arrayDeque = (T[])new Object[capacity];
		capacity=1000;
		front=size=0;
		rear=1;
	}
	public ArrayDeque(int c) {
		capacity =c;
		front=size=0;
		rear=1;
		arrayDeque = (T[])new Object[capacity];
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return  size==0;
	}
	public T first() {
		if(isEmpty()) return null;
		if (front==capacity-1) return arrayDeque[0];
		return arrayDeque[front];
	}
	public T last() {
		if(isEmpty()) return null;
		if (rear==0) return arrayDeque[capacity-1];
		return arrayDeque[rear-1];
	}
	public void addFirst(T data)throws IllegalStateException {
		if(size() ==capacity)
			throw new IllegalStateException("This Deque is full");
		arrayDeque[front] =data;
		front--;
		if(front<0) front = capacity-1;
		size++;
	}
	public void addLast(T data) throws IllegalStateException {
		if(size() ==capacity)
			throw new IllegalStateException("This Deque is full");
		arrayDeque[rear]=data;
		rear++;
		if(rear==capacity) rear=0;
		size++;
	}
	public T removeFirst() {
		if(isEmpty()) return null;
		T first = arrayDeque[front+1];
		front =front+1;
		if(front==capacity) front =0;
		size--;
		return first;
	}
	public T removeLast() {
		if(isEmpty()) return null;
		T last =  arrayDeque[rear-1];
		rear--;
		if(rear<0) rear = capacity-1;
		size--;
		return last;	
	}
	 public String toString() {
	        String ans = "ArrayDeque: ";
		if (isEmpty()) return null;
		if (front >= rear){
			for (int i = front+1; i < capacity-1; i++)
				ans += (arrayDeque[i] + " -> ");
			if (rear == 0) ans += arrayDeque[capacity-1];
			if (rear > 0){
				ans += (arrayDeque[capacity-1] + " -> ");
				for (int i = 0; i < rear-1; i++)
					ans += (arrayDeque[i] + " -> ");
				ans += arrayDeque[rear-1];
			}
		}else{
			for (int i = front+1; i < rear-1; i++)
				ans += (arrayDeque[i] + " -> ");
			ans += arrayDeque[rear-1];
		}

	        return ans;
	    }
	    
	    public static void main(String[] args) {
	    	 ArrayDeque<String> q = new ArrayDeque<String>(10);
	    	    q.addLast("t");
		        q.addLast("u");
		        q.addLast("v");
			System.out.println(q.toString()); // t -> u -> v
		//        q.dequeue();	q.dequeue();
			q.addFirst("a");
			q.addFirst("b");
			 System.out.println(q.toString());
			q.removeFirst();
			 System.out.println("removeFirst: "+q.toString());
			q.removeLast();
		        System.out.println(q.toString()); // v -> t
//			System.out.println(q.toString()); // t
		    }

		}

