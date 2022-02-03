package SingleLinkedList;

//create a single list
public class singleLinkedList<T>{
	//create node of list
	private Node<T> head, tail;//头节点和尾节点
	private int size;// the size of list
	//constructor of list
	public singleLinkedList() {
		head = tail = null;
		size=0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size ==0;
	}
	public T getFirst() {
		if(isEmpty()) return null;
		return head.getData();
	}
	public T getLast() {
		if(isEmpty()) return null;
		return tail.getData();
	}
	//add head of list

	public void addHead(T data) {
		Node<T> newNode = new Node<T>(data,head);
		head = newNode;
		 if(size == 0) {tail = head;}
			size++;		
	}
	public void addTail(T data) {
		Node<T> newNode = new Node<T>(data,null);
		if(isEmpty()) {
			head =tail = newNode;
		}else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}
	public T removeHead() {
		if(isEmpty()) {
			return null;
		}
		Node<T> temp =head;
		head = head.getNext();
		if(head == null) {
			tail=head;
		}
		size--;
		return temp.getData();
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
	 public void addSecond(T d){

		 if(head==null && tail==null ) return;
		 Node<T> newNode = new Node<T>(d,head.getNext());
		 Node<T> temp = head;
		 while(temp.getNext() != null){
			 head.setNext(newNode);
			 temp =temp.getNext();
		 }
		 }
	public T secondNode() {
		if(isEmpty()) return null;
		Node<T> temp = head;
		while(temp.getNext().getNext() != null) {
				temp = temp.getNext();
			}	
			return temp.getData();
		}	 
	
	public static void main(String[] args) {
        singleLinkedList<String> l = new singleLinkedList<String>();

	l.addTail("C");
	l.addHead("B");
	l.addTail("D");
	l.addHead("A");
	l.addSecond("F");
	l.secondNode();
	
	System.out.println(l);
	System.out.println(l.secondNode());
//	l.removeHead();
//	System.out.println(l);
    }

}
	
	
	
	
	
	
	
	
	
	

