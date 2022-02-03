package tree;

import java.util.ArrayList;

public class GeneralTree<T> extends Tree{
	public GeneralTree() {
		super();
	}
	public void add(T d) { // add root to a GeneralTree
		if(root != null)  throw new RuntimeException();
		root = new GTNode<T>(d,null);
		size++;
	}
	public void add(GTNode<T> node, T data) {//add a child to node
		GTNode<T> newNode = new GTNode<T>(data,node);
		node.add(newNode);
		size++;
	}
	//add a child to the ArrayList children at index i
	public void add(GTNode<T> position, int i, T data) {
		if(position.numberChildren()<i || i<0) 
			throw new RuntimeException("Illegal index within node.");
		GTNode<T> newNode = new GTNode<T>(data,position);
		position.add(newNode);
		size++;
	}
	public GTNode<T> remove(GTNode<T> node){
		GTNode<T> parent = (GTNode<T>) node.getParent();
		size -=node.size();
		if(parent==null) {
			root=null;
		}else
			parent.remove(node);
		return parent;
	}
	public String printGT() {
		return toString();
	}
	
	public static void main(String[] args) {
		GeneralTree<String> GT = new GeneralTree<String>();
//		GTNode<String> root1 = new GTNode<String>("A",null);
		GT.add("A");
		/*不修改 add*/
		GTNode root = (GTNode)GT.root();
		GTNode<String> node2 = new GTNode<String>("B",root);
		root.add(node2);
		GTNode<String> node3 = new GTNode<String>("C",root);
		root.add(node3);

		GTNode<String> node4 = new GTNode<String>("D",node2);
		node2.add(node4);
		GTNode<String> node5 = new GTNode<String>("E",node3);
		node3.add(node5);


//		/*修改add*/
//		GTNode root = (GTNode)GT.root();
//		GTNode<String> node2 = GT.add(root,"B");
//		GTNode<String> node3 = GT.add(root,"C");
//		GTNode<String> node4 = GT.add(node2,"D");
//		GTNode<String> node5 = GT.add(node3,"E");


		System.out.println(GT.printGT());
	}
}

