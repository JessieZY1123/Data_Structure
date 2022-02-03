package doubleLinkedList;

public class doubleLinkedList<T> {

	private DNode<T> header, tailer;
	private int size;

	public doubleLinkedList() {
		header = new DNode<T>(null, null, null);
		tailer = new DNode<T>(null, header, null);
		size = 0;
		header.setNext(tailer);	
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
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

	// insert after DNode v
	public void insertAfter(T data, DNode<T> v) {
		DNode<T> w = v.getNext();
		DNode<T> x = new DNode<T>(data, v, w);
		v.setNext(x);
		w.setPrev(x);
		size++;
	}

	// insert before DNode v
	public void insertBefore(T data, DNode<T> v) {
		DNode<T> u = v.getPrev();
		DNode<T> x = new DNode<T>(data, u, v);
		v.setPrev(x);
		u.setNext(x);
		size++;
	}

	public void addFirst(T data) {
		insertAfter(data, header);
	}

	public void addLast(T data) {
		insertBefore(data, tailer);
	}

	public T remove(DNode<T> v) {
		if (v == header || v == tailer)
			return null;
		DNode<T> u = v.getPrev();
		DNode<T> w = v.getNext();
		u.setNext(w);
		w.setPrev(u);
		size--;
		return v.getData();
	}
	public T middle() {
		if(isEmpty()) return null;
		DNode<T> headTemp = header.getNext();
		DNode<T> tailerTemp = tailer.getPrev();
		while(headTemp!= tailerTemp && headTemp.getNext()!= tailerTemp ) {
			headTemp = headTemp.getNext();
			tailerTemp = tailerTemp.getPrev();
		}
		return headTemp.getData();
	}
	// List testing methods
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
	public boolean equals(doubleLinkedList<T> listb) {
		DNode<T> temp1 = header;
        DNode<T> temp2 = listb.header; 
        int count=0;
        if(size !=listb.size) return false;
        else {
        	 // Iteratively compare the elements of both DL's
            // example: DLL_1 = 3<->7<->1<->9 & DLL_2 = 3<->7<->4<->9
            // when count = 0, DLL_1.data(3) = DLL_2.data(3) 
            // when count = 1, DLL_1.data(7) = DLL_2.data(7)
            // when count = 2, DLL_1.data(1) != DLL_2.data(4)
            //                 return false
        	while(count<size) {
        		  // If at any position, the element at DLL 1 is
                // different than the element at DLL 2, return false
                if (temp1.getData() != temp2.getData()) 
                    return false;       
                // If we reach here, then temp1.element is same as
                // temp2.element, so move to next nodes in both lists 
                temp1 = temp1.getNext(); 
                temp2 = temp2.getNext(); 
              count++;
        	}
        }
        return true;
	}

	public static void main(String[] args) {
		doubleLinkedList<String> dlist = new doubleLinkedList<String>();
		dlist.addFirst("A");
		dlist.insertAfter("C", dlist.getFirst());
		dlist.insertBefore("B", dlist.getLast());
		dlist.addLast("D");

		System.out.println(dlist);
		System.out.println(dlist.middle());

		dlist.remove(dlist.getLast().getPrev());
		System.out.println(dlist);
		System.out.println(dlist.middle());
		doubleLinkedList<Integer> list1 = new doubleLinkedList<Integer>();
		list1.addFirst(3);
		list1.insertAfter(7,list1.getFirst());
		list1.insertBefore(1, list1.getLast());
		list1.addLast(9);
		System.out.println(list1);
		doubleLinkedList<Integer> list2 = new doubleLinkedList<Integer>();
		list2.addFirst(3);
		list2.insertAfter(7,list2.getFirst());
		list2.insertBefore(4, list2.getLast());
		list2.addLast(9);
		System.out.println(list2);
		if(list2.equals(list1)) {
			System.out.println("true");
		}else {
			System.out.println("False");
		}
		

	}

}
