package ItQueue;

public class LinkedList<T> {
	protected  Node<T> head, tail;
    private int size;
    
    public LinkedList() {
        head = tail = null;
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public T head() {
        if (head == null) return null;
        return head.getData();
    }
    
    public void addHead(T d) {
        Node<T> n = new Node<T>(d, head);
        head = n;
        if(size == 0) tail = head;
	size++;
    }
    
    public void addTail(T d) {
        Node<T> n = new Node<T>(d, null);
        if(isEmpty())
            head = tail = n;
        else {
            tail.setNext(n);
            tail = n;
        }
        size++;
    }
    
    public T removeHead() {
        if(isEmpty()) return null;
        Node<T> n = head;
        head = head.getNext();
        if(head == null)
            tail = head;
        size--;
        return n.getData();
    }
    
    public String toString() {
        String ans = "";
        Node<T> n = head;
        ans += "(H) --> ";
        while(n != null) {
            ans += n.getData();
            ans += " --> ";
            n = n.getNext();
        }
        return ans + "(T)";
    }
    
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<String>();

	l.addTail("C");
	l.addHead("B");
	l.addTail("D");
	l.addHead("A");
	
	System.out.println(l);

	l.removeHead();
	System.out.println(l);
    }
}
