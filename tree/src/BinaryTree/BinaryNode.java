package BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class BinaryNode implements TNode{
	BinaryNode left, right, parent;
	public BinaryNode() {
		parent = left=right =null;
	}
	public BinaryNode(BinaryNode p, BinaryNode l,BinaryNode r){
		parent = p;
		left = l;
		right = r;
	}
	public Iterator<TNode> children(){
		ArrayList<TNode> children = new ArrayList<>();
		if(left!=null) children.add(left);//左结点不为空的话，arraylist加入左结点
		if(right!=null) children.add(right);
		return children.iterator();
	}
	public void setParent(BinaryNode n) {
		parent=n;
	}
	
	public BinaryNode getParent() {
		return parent;
	}
	public void setLeft(BinaryNode n) {
		left=n;
	}
	public void setRight(BinaryNode n) {
		right = n;
	}
	public BinaryNode getLeft() {
		return left;
	}
	public BinaryNode getRight() {
		return right;
	}
	public void removeChild(BinaryNode n) {
		if(getLeft()==n) setLeft(null);
		if(getRight()==n) setRight(null);
	}
	
}


