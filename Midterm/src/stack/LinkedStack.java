package stack;

import java.util.Iterator;

import singleLinkedList.Node;

public class LinkedStack<T> implements Stack<T>{
	 private SingleLinkedList<T> list;
	 public LinkedStack() {
		 SingleLinkedList<T> list = new SingleLinkedList<T>();	 
	 }
	 public int size() {
		 return list.size;
	 }
	
	 public boolean isEmpty() {
		 return list.isEmpty();
	}
	 /*
	  * puch 方法，就是在链表中添加头结点，然后pop是取出头结点。First in last out
	  * public void addFirst(T data) {
		Node<T> newNode = new Node<T>(data,head);
		head = newNode;
		//if(isEmpty())在这里是可以的，但是在stack中调用这个方法，就会造成java.lang.NullPointerException
		if(size==0) tail = head;
		size++;
	}
	  */
	 public void push(T data) {
		 list.addFirst(data);
	 }
	 /*
	  * public T removeFirst() {
		if(isEmpty()) return null;
		Node<T> temp = head;
		head =head.getNext();
		if(head == null) {
			tail=head;
		}
		size--;
		return temp.getData();
	}
	  */
	 public T pop() {
		return list.removeFirst();
	 }
	 public T top() {
		 return list.getFirst();
	 }
//	 public Node<T> iterator(Stack<T> stk){
//		 Iterator c = new Iterator<>();
//		 
//	 }
	  public String toString() {
	        /**String answer = "LinkedStack<T>: ";
	        Node<T> n = top;
	        while( n != null) {
	            answer += (n.getData() + " -> ");
	            n = n.getNext();
	        }**/
	        return "LinkedStack<T>: " + list.toString();
	    }
	   
	    public static void main(String[] args) {
	        Stack<Integer> S = new LinkedStack<>();
	        S.push(5);                              // contents: (5)
	        S.push(3);                              // contents: (5, 3)
	        System.out.println(S.size());           // contents: (5, 3)     outputs 2
	        System.out.println(S.pop());            // contents: (5)        outputs 3
	        System.out.println(S.isEmpty());        // contents: (5)        outputs false
	        System.out.println(S.pop());            // contents: ()         outputs 5
	        System.out.println(S.isEmpty());        // contents: ()         outputs true
	        System.out.println(S.pop());            // contents: ()         outputs null
	        S.push(7);                              // contents: (7)
	        S.push(9);                              // contents: (7, 9)
	        System.out.println(S.top());            // contents: (7, 9)     outputs 9
	        S.push(4);                              // contents: (7, 9, 4)
	        System.out.println(S.size());           // contents: (7, 9, 4)  outputs 3
	        System.out.println(S.pop());            // contents: (7, 9)     outputs 4
	        S.push(6);                              // contents: (7, 9, 6)
	        S.push(8);                              // contents: (7, 9, 6, 8)
	        System.out.println(S.pop());            // contents: (7, 9, 6)  outputs 8
	        System.out.println(S);
	       
	    }
		
	}

 