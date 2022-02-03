
package BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class BinaryNode implements TNode {
	BinaryNode left, right, parent;
	
	public BinaryNode() {
		 parent = left = right = null;
	}
	public BinaryNode(BinaryNode parent, BinaryNode left, BinaryNode right) {
		this.left = left;
		this.parent = parent;
		this.right = right;
	}
	public Iterator<TNode> children(){
		ArrayList<TNode> children = new ArrayList<>();
		if(left !=null) children.add(left);
		if(right !=null) children.add(right);
		return children.iterator();
	}
	
	public void setLeft(BinaryNode left) {
		this.left = left;
	}
	 public void setRight(BinaryNode right) {
	     this.right = right;
	   }
	 
	 public void setParent(BinaryNode parent) {
	      this.parent = parent;
	   }

	 public TNode getParent() {
		      return parent;
		}

	 public BinaryNode getLeft() {
	      return left;
	   }

	 public BinaryNode getRight() {
	      return right;
	   }
	 public void removeChild(BinaryNode n) {
	      if (getLeft() == n)
	         setLeft(null);
	      if (getRight() == n)
	         setRight(null);
	   }
}
