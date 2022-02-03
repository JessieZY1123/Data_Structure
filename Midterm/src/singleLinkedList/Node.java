package singleLinkedList;

public class Node<T> {
	private T  data;
	private Node<T> next;
	public Node() {
		data =null;
		next = null;
	}
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next =next;
	}
	public void setData(T data) {
		this.data = data;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public T getData() {
		return data;
	}
	public Node<T> getNext(){
		return next;
	}
	public String toString() {
		String ans =" ";
		if(this!=null) {
			ans =ans + this.data;
			Node<T> node = this.next;
			if(node != null) 
				ans = ans + "-->" + node.data;
		}
		return ans;
	}
}
