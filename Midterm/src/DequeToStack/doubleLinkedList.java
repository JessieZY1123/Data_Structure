package DequeToStack;

public class doubleLinkedList<T> {
	DNode<T> head, tail;
	int size;
	
	public doubleLinkedList() {
		 head = new DNode<T>(null,null,null);
		 tail = new DNode<T>(null,head,null);
		 head.setNext(tail);
		 size =0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public DNode<T> getFirst() {
		if(isEmpty()) return null;
		return head.getNext();
	}
	
	public DNode<T> getLast() {
		if(isEmpty()) return null;
		return tail.getPre();
	}
	public DNode<T> getNext(DNode<T> node){
		DNode<T> next = node.getNext();
		if(next==null|| tail ==next) return null;
		return next;
	}
	public DNode<T> getPre(DNode<T> node){
		DNode<T> prev = node.getPre();
		if(prev==null||prev==head) return null;
		return prev;
	}
	public T getMiddle() {
		if(isEmpty()) return null;
		DNode<T> headPionter = head.getNext();
		DNode<T> tailPionter = tail.getPre();
		while(headPionter != tailPionter && headPionter.getNext()!=tailPionter ) {
			headPionter =headPionter.getNext();
			tailPionter =tailPionter.getPre();
		}
		return headPionter.getData();
	}
	
	public void insertAfter(T data, DNode<T> node) {
		DNode<T> after = node.getNext();
		DNode<T> newNode = new DNode<T>(data,node,after);
		node.setNext(newNode);
		after.setPre(newNode);
		size++;
	}
	public void insertBefore(T data, DNode<T> node) {
		DNode<T> before = node.getPre();
		DNode<T> newNode = new DNode<T>(data,before,node);
		before.setNext(newNode);
		node.setPre(newNode);
		size++;
	}
	public void addFirst(T data) {
		insertAfter(data,head);
	}
	public void addLast(T data) {
		insertBefore(data,tail);
	}
	public void addSecondNode(DNode<T> node) {
		if(isEmpty()) {
			head.setNext(node);
			node.setPre(head);
			tail.setPre(node);
		}
		DNode<T> first = head.getNext();
		if(size==1) {
			first.setNext(node);
			node.setPre(first);
			tail.setPre(node);
		}else {
			DNode<T> second = first.getNext();
			node.setNext(second);
			first.setNext(node);
			node.setPre(first);
			second.setPre(node);
		}
		size++;
	}
	public void addLastSecNode(DNode<T> node) {
		if(isEmpty()) {
			head.setNext(node);
			node.setPre(head);
			tail.setPre(node);
		}
		DNode<T> first = head.getNext();
		if(size==1) {
			first.setNext(node);
			node.setPre(first);
			tail.setPre(node);
		}else {
			DNode<T> last = tail.getPre();
			DNode<T> secLast = last.getPre();
			node.setNext(last);
			node.setPre(secLast);
			secLast.setNext(node);
			last.setPre(node);
			}
		size++;
	}
	
	public void addSecond(T data) {
		if(isEmpty()) insertAfter(data,head);
		DNode<T> first = head.getNext();
		insertAfter(data,first);
		size++;
	}
	
	public void addLastSecond(T data) {
		DNode<T> last = tail.getPre();
		insertBefore(data,last);
		size++;
	}
	public T remove(DNode<T> node) {
		if(node==head||node==tail) return null;
		DNode<T> pre = node.getPre();
		DNode<T> next = node.getNext();
		pre.setNext(next);
		next.setPre(pre);
		size--;
		return node.getData();
	}
	
	public T removeSecond(){
		if(size<2) return null;
		
		DNode<T> first = head.getNext();
		
		if(size == 2) {
			DNode<T> second = first.getNext();
			first.setNext(tail);
			tail.setPre(first);
			size--;
			return second.getData();
		}else {
			DNode<T> second = first.getNext();
			DNode<T> third = second.getNext();
			first.setNext(third);
			third.setPre(first);
			size--;
			return second.getData();
		}
	}
	public T removeLastSec() {
		if(size<2) return null;
		DNode<T> last = tail.getPre();
		if(size==2) {
			DNode<T> first = head.getNext();
			head.setNext(last);
			last.setPre(head);
			size--;
			return first.getData();
		}else {
			DNode<T> lastSec = last.getPre();
			DNode<T> lastThi = lastSec.getPre();
			lastThi.setNext(last);
			last.setPre(lastThi);
			size--;
			return  lastSec.getData();
		}
		
	}
	public String toString() {
		String ans = "";
		DNode<T> temp = head;
		ans += "(H)-->";
		do {
			temp = temp.getNext();
			if (temp == tail)
				ans += "(T)";
			else {
				ans += temp.getData();
				ans += "<->";
			}
		} while (temp != tail);
		return ans;
	}
	public static void main(String[] args) {
		doubleLinkedList<String> dlist = new doubleLinkedList<String>();
		doubleLinkedList<String> dlist1 = new doubleLinkedList<String>();
		DNode<String> newNode = new DNode<String>("H",null,null);
		DNode<String> newNode1 = new DNode<String>("J",null,null);
		dlist.addFirst("A");
		dlist.insertAfter("C",dlist.getFirst());
		dlist.insertBefore("B", dlist.getLast());
		dlist.addLast("D");
		dlist.addSecond("T");
		dlist.addLastSecond("N");
		System.out.println(dlist);
		System.out.println(dlist.getMiddle());
		dlist.addLastSecNode(newNode);
		System.out.println(dlist);
		dlist.addSecondNode(newNode1);
		System.out.println(dlist);
		dlist.removeSecond();
		System.out.println("RemoveSecond: "+dlist);
		dlist.removeLastSec();
		System.out.println("Remove Last Second: "+dlist);
		dlist1.addFirst("A");
		dlist1.addLast("D");
		System.out.println("dlist1: "+dlist1);
		dlist1.removeSecond();
//		dlist1.removeLastSec();
		System.out.println("dlist1: "+dlist1);
	}
}
