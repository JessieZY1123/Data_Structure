package tree;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * GTNode rewrite the methods of TNode to implement the TNode
 */
public class GTNode<T> implements TNode{
	   T data;
	   GTNode<T> parent;
	   private ArrayList<TNode> children;
	   public GTNode(T d, GTNode<T> node) {
		   parent = node;
		   data = d;
		   children = new ArrayList<TNode>();
	   }
	   /**
	    * 
	    */
	   public Iterator<TNode> children(){
		   return children.iterator();
	   }
	   /**
	    * 
	    */
	   public GTNode<T> getParent(){
		   return parent;
	   }
	   /**
	    * 
	    */
	   public String printData() {
		   return data.toString();
	   }
	   /**
	    * 
	    * @param n
	    */
	   public void add(GTNode<T> n) {
		   children.add(n);
	   }
	   /**
	    * 在数组的第i的元素里插入GTNode n
	    * @param i the index of children ArrayList
	    * @param n the node which is added to the ArrayList
	    */
	   public void add(int i, GTNode<T> n) {
		   children.add(i, n);
	   }
	   public GTNode<T> getChild(int i){
		   return (GTNode<T>) children.get(i);
	   }
	   public int numberChildren() {
		   return children.size();
	   }
	   /**
	    * 子树的root个数
	    * @return
	    */
	   public int size() {
		   int count =1;
		   Iterator<TNode> x= children();
		   while(x.hasNext()) {
			   count += ((GTNode<T>) x.next()).size(); //recursion
		   }return count; 
	   }
	   public void remove(GTNode<T> n) {
		   children.remove(n);
	   }
	   
	   public static void main(String[] args) {
		    ArrayList<TNode> children = new ArrayList<TNode>();
		    ArrayList<GTNode> listTree = new ArrayList<GTNode>();
			GTNode<String> root = new GTNode<String>("A",null);
			GTNode<String> node2 = new GTNode<String>("B",root);
			GTNode<String> node3 = new GTNode<String>("C",root);
			GTNode<String> node4 = new GTNode<String>("D",node2);
			GTNode<String> node5 = new GTNode<String>("E",node3);
			root.add(0,node2);	
			root.add(1,node3);
			
//			node2.add(node4);
//			node5.add(node3);
			System.out.println(node4.getParent().printData());
			System.out.println(root.getChild(0).printData());
			System.out.println(root.printData());
			
		}
}
