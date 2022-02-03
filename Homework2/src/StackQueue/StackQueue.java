package StackQueue;
import java.util.Stack;
public class StackQueue<T> implements Queue<T> {
	private Stack<T> inStack;
	private Stack<T> outStack;
	int size;
	public StackQueue() {
		inStack  = new Stack<T>();
		outStack = new Stack<T>(); //part(a)
		size = 0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}	
	public T first() {
		if(size == 0) return null;
		if(outStack.empty()) {
			while(!inStack.empty()) {
				outStack.push(inStack.pop()); 
			}
		}
		return outStack.peek(); //part(b)
	}
	public void enqueue(T x){
		inStack.push(x);//part(c)
		size++;
	}
	public T dequeue() {
		if(size == 0) return null;//part(d)
		if(outStack.empty()) {
			while(!inStack.empty()) {
				outStack.push(inStack.pop());
			}
			size--;
		}
		return outStack.pop();// part(e)
	}
	
	public String toString(){
		Stack<T> temp = new Stack<>();
		String ans = "StackQueue: ";
		if (isEmpty()) return ans;;
		if (outStack.empty())
			while (!inStack.empty())
				outStack.push(inStack.pop());

		while (!outStack.empty()){
                        T x = outStack.pop();
                        ans += (x + " -> ");
                        temp.push(x);
                }

		while (!inStack.empty())
			outStack.push(inStack.pop());
		while (!outStack.empty()){
                        T x = outStack.pop();
                        ans += (x + " -> ");
                        temp.push(x);
                }

		while (!temp.empty())
			outStack.push(temp.pop());

		return ans;
	}
	public static void main(String[] args){
		StackQueue<Integer> q = new StackQueue<>();
		q.enqueue(0); //0
		System.out.println("first element: " + q.first());
		q.enqueue(1);// 0,1
		q.enqueue(2);//0,1,2
		System.out.println(q.toString());//0.1,2
		q.dequeue();//1,2
		System.out.println(q.toString());//1->2
		System.out.println("first element: " + q.first()); //1
		q.enqueue(3);//1,2,3
		q.enqueue(4);//1,2,3,4
		q.enqueue(5);//1,2,3,4,5
		System.out.println(q.toString());//1->2->3->4->5
		q.dequeue();//2,3,4,5
		System.out.println(q.toString());//2,3,4,5
		System.out.println("first element: " + q.first());
	}

}
