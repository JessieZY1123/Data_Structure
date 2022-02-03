package BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;

public class BST<K extends Comparable<K>> extends BinTree<K> {
	
	public BinNode<K> findNode(K target){
		 if (root() == null)
	         return null;
	      return recursiveFindNode((BinNode<K>) root(), target);
	}

	/*
	 * 从node结点开始找 K target这个值。
	 * 如果node结点后面的结点包含target 这个值，则返回此结点
	 * 如果没有，则返回target 这个值的父节点。
	 */
	private BinNode<K> recursiveFindNode(BinNode<K> node, K target) {
		int comparison =target.compareTo(node.getData()); //target 和 node比较
		if(comparison==0) return node ;
		if(comparison<0 && node.getLeft()!=null)
			recursiveFindNode( (BinNode<K>) node.getLeft(),target);
		if(comparison>0 && node.getRight()!=null)
			recursiveFindNode((BinNode<K>) node.getRight(), target);
		return node;
	}
	//考虑找不到 这个值的情况
	 public void remove(K target) throws Exception {
	      BinNode<K> n = findNode(target);
	      if (n == null || !n.getData().equals(target)) throw new Exception("Target not present");
	      removeNode(n);
	   }
	 
	 public void add(K newData) throws Exception {
		 BinNode<K> node = findNode(newData); //找到位置
		 if(node ==null) {
			 addRoot(newData);
		 }else if ((node.getData()).compareTo(newData) > 0) { // newData 和它的父节点比较 父节点大
			addLeft(node, newData); //放左边
		}else if ((node.getData()).compareTo(newData) < 0) {
			 addRight(node, newData);
		}else node.setData(newData); //相等的情况
	 }	
	 public boolean contains(K target) {
	      BinNode<K> node = findNode(target);
	      if (node == null || !node.getData().equals(target))
	         return false;
	      return true;
	   }

	   public boolean isEmpty() {
	      return root == null;
	   }

	   public K get(K partialData) {
	      BinNode<K> node = findNode(partialData);
	      if (node == null || !node.getData().equals(partialData))
	         return null;
	      return node.getData();
	   }
	   public Iterator<K> iterator(){
		   ArrayList<TNode> list = inOrder();
		   ArrayList<K> dataList = new ArrayList<K>();
		   for(TNode node : list) dataList.add(((BinNode<K>) node).getData());
		   return dataList.iterator();
	   }
	   public void dumpData() {
		      System.out.println(treePrint(null));
		   }
	// when removing from a BST, we can only promote from a neighbor in order
	   //在中序遍历的顺序，删除的结点与相邻结点交换 (都可以)
	   
	   protected BinaryNode descendant(BinaryNode node) {
		   BinaryNode lower = node.getLeft();
		   if(lower!=null) { //左子节点不为空
			   while(lower.getRight()!=null) 
				   lower = lower.getRight(); //左子节点的右儿子
				   return lower;
		   }
		   
		   lower = node.getRight();
		      if (lower != null) {
		         while (lower.getLeft() != null) 
		        	 lower = lower.getLeft(); //右子节点的左儿子
		         return lower;   // immediate successor of node (in order)
		      }
		      
		      return null;
	   }
	   
}
