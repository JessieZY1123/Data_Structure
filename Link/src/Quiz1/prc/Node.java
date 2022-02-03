package Quiz1.prc;

//create a node	
public class Node<T>{
	private T data;
	private Node<T> next;
//Constructor of class Node	
	public Node(){
		data=null;
		next=null;		
	}
	public Node(T data, Node<T> next){
		this.data=data;
		this.next =next;
	}
	//Set methods
	public void setData(T data) {
		this.data =data;
	}
	public void setNext(Node<T> next) {
		this.next =next;
	}
	//Get methods
	public T getData() {
		return data;
	}
	public Node<T> getNext(){
		return next;
	}
	// toString method
	public String toString() {
		String res ="";
		//this = Node<T> node
		if(this !=null) {
			res += this.data;
			Node<T> node = this.next;
			if(node != null) res = res + "-->" + node.data;
		}
		return res;
			
	}
}