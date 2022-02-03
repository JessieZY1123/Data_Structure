package Quiz1.prc;

import SingleLinkedList.Node;

public class CList<T> {
	/* The designated cursor of the list */
	private Node<T> cursor;
	private int size;

	public CList() {
		cursor = null;
		size = 0;
	}

	/**
	 * Returns the number of nodes in the linked list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Insert a node after the cursor
	 */
	public void insert(T d) {
		if (size == 0) {
			Node<T> n = new Node<T>(d, null);
			n.setNext(n);
			cursor = n;
		} else {
			Node<T> newNode = new Node<T>(d, cursor.getNext());
			cursor.setNext(newNode);
			cursor = newNode;

		}
		size++;
	}
	public String toString() {
        String ans = "";
        Node<T> temp = cursor.getNext();
        ans += "^ --> ";
        if(temp != null) {
        	for(int i=0;i<size;i++) {
            ans += temp.getData();
            ans += " --> ";
            temp = temp.getNext();//指针后移
        }}
        return ans + "v";
    }
	public static void main(String[] args){
		CList<String> cl = new CList<String>();
		cl.insert("A");
		cl.insert("B");
		cl.insert("C");
		System.out.println(cl.size()); // PART(d)
		System.out.println(cl); //PART(e)
		}
}
