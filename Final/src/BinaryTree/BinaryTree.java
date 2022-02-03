package BinaryTree;

import java.util.ArrayList;

public abstract class BinaryTree extends Tree{

	public BinaryTree() {
		super();
	}
	public void addRoot(BinaryNode node) throws Exception{
		if(root != null) 
			throw new Exception("The tree is not empty.");
	}
	
	public void addLeft(BinaryNode node, BinaryNode newChild) throws Exception{
		if(node.getLeft()!=null)
			throw new Exception("Left child already exists.");
		node.setLeft(newChild);
		newChild.setParent(node);
		size++;
	}
	public void addRight(BinaryNode node, BinaryNode newChild) throws Exception{
		if(node.getRight()!=null)
			throw new Exception("Left child already exists.");
		node.setRight(newChild);
		newChild.setParent(node);
		size++;
	}
		// removes a leaf but promotes and removes a descendant otherwise
	   // returns the parent of the node that is actually removed
	//叶子节点： 返回它的父节点
	public BinaryNode removeNode(BinaryNode node) {
		if(isLeaf(node)) {
			BinaryNode parent = (BinaryNode) node.getParent();
			if (parent == null)
	            root = null;
	         else
	            parent.removeChild(node);
	         size--;
	         return parent;
		}
		BinaryNode lower = descendant(node);
		promote(lower,node); //swap
		return removeNode(lower);
	}
	   protected abstract void promote(BinaryNode lower, BinaryNode node);

	   protected abstract BinaryNode descendant(BinaryNode node);
//	   protected void promote(BinaryNode lower, BinaryNode node) {
//		   node = lower;
//	   }
//
//	   protected  BinaryNode descendant(BinaryNode node) {
//		   if (node.getLeft() != null) return node.getLeft();
//		      return node.getRight();
//	   }
	   public ArrayList<TNode> inOrder(){
		   ArrayList<TNode> answer = new ArrayList<TNode>();
		   inOrder((BinaryNode)root(), answer);
		   return answer;
	   }
	   public void inOrder(BinaryNode node, ArrayList<TNode> v) {
		   if(node==null)
			   return;
		   inOrder(node.getLeft(),v);
		   v.add(node);
		   inOrder(node.getRight(),v);
	   }
	   public ArrayList<TNode> flatOrder() {
		      return inOrder();
		   }
}
