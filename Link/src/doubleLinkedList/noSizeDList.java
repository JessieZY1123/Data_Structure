package doubleLinkedList;

import SingleLinkedList.Node;

public class noSizeDList<T> {
	private DNode<T> header, tailer;
	
	public noSizeDList() {
		header = new DNode<T>(null, null, null);
		tailer = new DNode<T>(null, header, null);
		header.setNext(tailer);
	}
	public boolean isEmpty() {
		return header==tailer;
	}
	public DNode<T> getFirst() {
		if (isEmpty())
			return null;
		return header.getNext();
	}

	public DNode<T> getLast() {
		if (isEmpty())
			return null;
		return tailer.getPrev();
	}

	public DNode<T> getNext(DNode<T> v) { // 获得v节点的后一个节点
		DNode<T> next = v.getNext();
		if (next == null || next == tailer)
			return null;
		return next;
	}

	public DNode<T> getPrev(DNode<T> v) { // 获得v节点的前一个节点
		DNode<T> prev = v.getPrev();
		if (prev == null || prev == header)
			return null;
		return prev;
	}
	public void insertAfter(T data, DNode<T> v) {
		DNode<T> w = v.getNext();
		DNode<T> x = new DNode<T>(data, v, w);
		v.setNext(x);
		w.setPrev(x);
	}

	// insert before DNode v
	public void insertBefore(T data, DNode<T> v) {
		DNode<T> u = v.getPrev();
		DNode<T> x = new DNode<T>(data, u, v);
		v.setPrev(x);
		u.setNext(x);
	}
	public void addFirst(T data) {
		insertAfter(data, header);
	}

	public void addLast(T data) {
		insertBefore(data, tailer);
	}
	public int size() {
		int size =0;
		if(isEmpty()) return 0;
		DNode<T> temp = header.getNext();
		while(temp!=null) {
			size++;
			temp = temp.getNext();
		}
		return size;
	}
	public String toString() {
		String ans = "";
		DNode<T> temp = header;
		ans += "(H)-->";
		do {
			temp = temp.getNext();
			if (temp == tailer)
				ans += "(T)";
			else {
				ans += temp.getData();
				ans += "<->";
			}
		} while (temp != tailer);
		return ans;
	}
	public static void main(String[] args) {
		doubleLinkedList<String> dlist = new doubleLinkedList<String>();
		dlist.addFirst("A");
		dlist.insertAfter("C", dlist.getFirst());
		dlist.insertBefore("B", dlist.getLast());
		dlist.addLast("D");

		System.out.println(dlist);
		System.out.println(dlist.size());

	}
}
