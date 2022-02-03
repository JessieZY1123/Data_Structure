package Deque;

public class DNode<T> {
	private T data;
	private DNode<T> pre;
	private DNode<T> next;
	public DNode() {
		data =null;
		pre=next=null;
	} 
	public DNode(T data,DNode<T> pre, DNode<T> next) {
		this.data =data;
		this.pre =pre;
		this.next =next;
	}
	public void setData(T data) {
		this.data = data;
	}
	public void setPre(DNode<T> pre) {
		this.pre =pre;
	}
	public void setNext(DNode<T> next) {
		this.next =next;
	}
	public T getData() {
		return data;
	}
	public DNode<T> getPre(){
		return pre;
	}
	public DNode<T> getNext(){
		return next;
	}
	
}
