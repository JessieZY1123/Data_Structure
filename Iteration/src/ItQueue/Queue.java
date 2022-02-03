package ItQueue;

public interface Queue<T> {
	void enqueue(T e);
	T dequeue();
	int size();
	boolean isEmpty();
	T first();//return but not remove the first of queue
}
