package BinaryTree;
/*
 * new add and remove methods are similar to those for BSTs except:
 * 1. they only ever add AVLNodes
 * 2. they finish by rebalancing at the node that was changed
 */
public abstract class AVLTree<K extends Comparable<K>> extends BST<K>{
	public AVLTree() {
		super();
	}
	public void addRoot(K data) throws Exception{
		if(root !=null)
			throw new Exception("The tree is not empty");
		root = new AVLNode<K> (null,null,null,data);
		size++;
	}
	public void addLeft(AVLNode<K> node, K data) throws Exception {
	      if (node.getLeft() != null)
	         throw new Exception("Attempt to replace existing node.");
	      node.setLeft(new AVLNode<K>(node, null, null, data));
	      size++;
	      rebalance(node);  // to deal with potential balance problems above the node
	   }

	   public void addRight(AVLNode<K> node, K data) throws Exception {
	      if (node.getRight() != null)
	         throw new Exception("Attempt to replace existing node.");
	      node.setRight(new AVLNode<K>(node, null, null, data));
	      size++;
	      rebalance(node);
	   }
	   public void remove(K data) throws Exception {
		      AVLNode<K> target = (AVLNode<K>) findNode(data);
		      if (target == null || !target.getData().equals(data)) 
		         throw new Exception("Target data not found");
		      AVLNode<K> parent = (AVLNode<K>) removeNode(target);  // parent has just lost a node, so rebalance
		      rebalance(parent);
		   }
	   /* the important methods to rebalance and rebuild in an AVL tree
	    * decide whether and which rotation can fix balance at node and then recursively rebalance parent if needed
	    */
	   @SuppressWarnings("unchecked")
	public void rebalance(AVLNode<K> node) {
		   if(node == null) return;
		   int oldMaxHt = AVLNode.max(node.leftChildHt, node.rightChildHt);
		   int newMaxHt = node.fixHt();
		   // rotation required
		   if(newMaxHt > node.leftChildHt+1||newMaxHt>node.rightChildHt+1) {
			  AVLNode<K> leftChild = (AVLNode<K>) node.getLeft();
			  AVLNode<K> rightChild = (AVLNode<K>) node.getRight();
			 
			  if (node.leftChildHt > node.rightChildHt && 
		               leftChild.leftChildHt >= leftChild.rightChildHt) // single rotate at left
		            rebuildNode(node, leftChild, (AVLNode<K>) leftChild.getLeft(), node, 
		                  (AVLNode<K>) leftChild.getLeft().getLeft(), (AVLNode<K>) leftChild.getLeft().getRight(), 
		                  (AVLNode<K>) leftChild.getRight(), rightChild);
			  
		         else if (node.leftChildHt > node.rightChildHt) // double rotate at left
		            rebuildNode(node, (AVLNode<K>) leftChild.getRight(), leftChild, node, 
		                  (AVLNode<K>) leftChild.getLeft(), (AVLNode<K>) leftChild.getRight().getLeft(), 
		                  (AVLNode<K>) leftChild.getRight().getRight(), rightChild);
		         else if (rightChild.rightChildHt >= rightChild.leftChildHt) // single rotate at right
		            rebuildNode(node, rightChild, node, (AVLNode<K>) rightChild.getRight(), 
		                  leftChild, (AVLNode<K>) rightChild.getLeft(), 
		                  (AVLNode<K>) rightChild.getRight().getLeft(), (AVLNode<K>) rightChild.getRight().getRight());
		         else   // double rotate at right
		            rebuildNode(node, (AVLNode<K>) rightChild.getLeft(), node, rightChild, 
		                  leftChild, (AVLNode<K>) rightChild.getLeft().getLeft(), 
		                  (AVLNode<K>) rightChild.getLeft().getRight(), (AVLNode<K>) rightChild.getRight());
		      }
		      newMaxHt = node.fixHt();
		      if (oldMaxHt != newMaxHt) rebalance((AVLNode<K>) node.getParent());
		   }

		   /* node is rebuilt so that its data and child data is from putTop, putLeft, putRight
		    * and the 4 subtrees under its children are subTree1 ... subTree4 in order.
		    * this one function can carry out both single and double rotations
		    */
		   public void rebuildNode(AVLNode<K> node, AVLNode<K> putTop, AVLNode<K> putLeft, AVLNode<K> putRight,
		         AVLNode<K> subTree1, AVLNode<K> subTree2, AVLNode<K> subTree3, AVLNode<K> subTree4) {
		      AVLNode<K> newLeft = new AVLNode<K>(node, subTree1, subTree2, putLeft.getData());
		      AVLNode<K> newRight = new AVLNode<K>(node, subTree3, subTree4, putRight.getData());
		      if (subTree1 != null) subTree1.setParent(newLeft);
		      if (subTree2 != null) subTree2.setParent(newLeft);
		      if (subTree3 != null) subTree3.setParent(newRight);
		      if (subTree4 != null) subTree4.setParent(newRight);
		      newLeft.fixHt();
		      newRight.fixHt();
		      node.setData(putTop.getData());
		      node.setLeft(newLeft);
		      node.setRight(newRight);
		   }
	   }

