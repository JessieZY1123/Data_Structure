package BinaryTree;

public class BinNode<T> extends BinaryNode{
	T data;
	
	public BinNode() {
		super();
	} 
	public BinNode(BinNode<T> parent, BinNode<T> left, BinNode<T> right, T data) {
	      super(parent, left, right);
	      this.data =data;
	   }	
	 public String printData() {
	      return data.toString();
	   }
	   public T getData() {
	      return data;
	   }
	   public void setData(T newData) {
	      data = newData;
	   }
}
