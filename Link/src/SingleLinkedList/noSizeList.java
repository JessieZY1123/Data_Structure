package SingleLinkedList;

public class noSizeList<T> {
	private Node<T> head,tail;
	
	public noSizeList() {
		head=tail=null;
	}
	public boolean isEmpty() {
		return head==null && tail==null;
	}
	public T getFirst() {
		if(isEmpty()) return null;
		return head.getData();
	}
	public T getLast() {
		if(isEmpty()) return null;
		return tail.getData();
	}
	public void addHead(T data) {
		Node<T> newNode = new Node<T>(data,head);
		head = newNode;
		 if(isEmpty()) {tail = head;}	
	}
	public void addTail(T data) {
		Node<T> newNode = new Node<T>(data,null);
		if(isEmpty()) {
			head =tail = newNode;
		}else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}
	public int getSize() {
		int size =0;
		if(isEmpty()) return 0;
		Node<T> temp = head;//head 就已经是第一个节点了
		while(temp!=null) {
			size++;
			temp = temp.getNext();
		}
		return size;
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
	      noSizeList<String> l = new noSizeList<String>();

		l.addTail("C");
		l.addHead("B");
		l.addTail("D");
		l.addHead("A");
		
		System.out.println(l);
		System.out.println(l.getFirst());
		System.out.println(l.getSize());
}
}