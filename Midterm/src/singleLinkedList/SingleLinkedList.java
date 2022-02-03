package singleLinkedList;


public class SingleLinkedList<T> {
	private Node<T> head, tail;
	int size;
	public SingleLinkedList() {
		head = tail =null;
		size=0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return size;
	}
	
	public T getFirst(){
		if(isEmpty()) return null;
		return head.getData();
	}
	public T getLast() {
		if(isEmpty()) return null;
		return tail.getData();
	}
	public T getSecond() {
		if(isEmpty()) return null;
		return head.getNext().getData();
	}
	
	public T getLastSecond() {
		if(size<2) return null;
		else {
		Node<T> temp =head;// pointer
		while(temp.getNext().getNext()!=null) { //如果head.next.next =null, 就跳出循环，此刻temp就是倒数第二个值
			temp = temp.getNext();
		}return temp.getData();}
	}
	public T getMiddle() {
		if(isEmpty()) return null;
		Node<T> temp =head;
		if(size%2!=0) {
			for(int i=0; i<size/2;i++) {
				temp= temp.getNext();
			}return temp.getData();
		}else {
			for(int i=0; i<(size/2)-1;i++) {
				temp= temp.getNext();
			} return temp.getData();}
	}
	public void addFirst(T data) {
		Node<T> newNode = new Node<T>(data,head);
		head = newNode;
		//if(isEmpty())在这里是可以的，但是在stack中调用这个方法，就会造成java.lang.NullPointerException
		if(size==0) tail = head;
		size++;
	}
	public void addFirstNode(Node<T> node) {
		if(isEmpty()) head = tail=node;
		node.setNext(head);
		head=node;
		size++;
	}
	public void addSecond(T data) {
		if(size==0) return;
		if(size==1) {
			Node<T> second = new Node<T>(data,null);
			head.setNext(second);
			tail= second;
		}else {
			Node<T> second = new Node<T>(data, head.getNext());
			head.setNext(second);
		}size++;
	}
	public void addLast(T data) {
		Node<T> newNode = new Node<T>(data,null);
		if(isEmpty()) head =tail= newNode;
		tail.setNext(newNode);
		tail = newNode;
		size++;
	}
	public void addLastSec(T data) {
		if(size<2) addFirst(data);
		else {
		Node<T> temp = head;
		Node<T> newNode = new Node<T>(data,tail);
		while(temp.getNext()!=tail) {
			temp=temp.getNext();
		}
		temp.setNext(newNode);
		size++;
		}
	}
	public T removeFirst() {
		if(isEmpty()) return null;
		Node<T> temp = head;
		head =head.getNext();
		if(head == null) {
			tail=head;
		}
		size--;
		return temp.getData();
	}
	public T removeSecond() {
		if(size<2) return null;
		Node<T> second = head.getNext();
		if(size == 2) {
			head.setNext(null);
			tail = head;
		}else {
		Node<T> third = second.getNext();
		head.setNext(third);
		}
		size--;
		return second.getData();
	}
	public T removeLastSecond() {
		if(size<2) return null;
		Node<T> temp =head;
		Node<T> tempNext = head.getNext();
		while(tempNext.getNext()!=tail) {
			temp =temp.getNext();
			tempNext = tempNext.getNext();
		}
		temp.setNext(tail);
		size--;
		return tempNext.getData();
	}
	 public String toString() {
	        String ans = "";
	        Node<T> temp = head;
	        ans += "(H) --> ";
	        while(temp != null) {
	            ans += temp.getData();
	            ans += " --> ";
	            temp = temp.getNext();//指针后移
	        }
	        return ans + "(T)";
	    }
	 public static void main(String[] args) {
	        SingleLinkedList<String> l = new SingleLinkedList<String>();

		l.addFirst("B");
		l.addSecond("S");
		l.addLastSec("A");
		l.addLast("D");
		
		
		System.out.println(l);
		System.out.println(l.getSecond());
		System.out.println("getLastSecond():"+ l.getLastSecond());
		System.out.println(l.getMiddle());
		l.removeLastSecond();
	//	System.out.println("Remove Last sec"+l.removeLastSecond());
		System.out.println("Remove Last sec"+l);
		l.removeFirst();
		System.out.println(l);
//		l.removeHead();
//		System.out.println(l);
	    }
}
