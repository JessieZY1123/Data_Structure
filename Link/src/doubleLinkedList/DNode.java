package doubleLinkedList;

public class DNode<T> {
	private T data;
	private DNode<T> prev, next;
	
	public DNode() {
		prev = next = null;
		data = null;
	}
	public DNode(T data, DNode<T> prev, DNode<T> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	public void setData(T data) {
		this.data = data;
	}
	public void setPrev(DNode<T> prev) {
		this.prev = prev;
	}
	public void setNext(DNode<T> next) {
		this.next = next;
	}
	public T getData() {
		return data;
	}
	public DNode<T> getPrev(){
		return prev;
	}
	public DNode<T> getNext(){
		return next;
	}
}

