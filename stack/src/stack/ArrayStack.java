package stack;

public class ArrayStack<T> implements Stack<T>{
	private T[] data;
	private int top; //index of stack top data
	public ArrayStack() {
		data = (T[]) new Object[1000];
		top = -1;
	}
	//method of get array size
	public int size() {
		return top+1;
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public void push(T x) throws IllegalStateException{
		if(size()==100)
			throw new IllegalStateException("Stack is full");
		data[++top] = x;// top =top+1; data[top]=x; 先加一，在赋值
		//data[top++] =x;
	}
	public T pop() {
		if(isEmpty()) return null;
		return data[top--];//data[top]; top--;
	//	return data[--top];
	}
	public T top() {
		if(isEmpty()) return null;
		return data[top];
	}
	public String toString() {
		String ans ="ArrayStack<T>:";
		for(int i=top; i>=0;i--) {
			if(i>0) ans += (data[i]+"->");
			else ans += data[i];
		}
		return ans;
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new ArrayStack<Integer>(); //contents()
		stack.push(5);//contents(5)
		stack.push(3);//contents(3,5)
		System.out.println(stack.size());// size is 2
		System.out.println(stack.pop()); // delete the top one 3 ,contents:(5)
		System.out.println(stack.isEmpty());//contents:(5)
		System.out.println(stack.pop());//delete the top one 5
		System.out.println(stack.isEmpty());////contents:( ) true
		System.out.println(stack.pop()); //return null
		stack.push(7); //(7)
		stack.push(9);//(9,7)
		System.out.println(stack.top());// top one is 9
		stack.push(4);//(4,9,7)
		System.out.println(stack.size());//3
		System.out.println(stack.pop()); //top one is 4
		stack.push(6);//6,9,7
		stack.push(8);//8,6,9,7
		System.out.println(stack.pop());//delete 8
		System.out.println(stack);//6-9-7
	}
}
