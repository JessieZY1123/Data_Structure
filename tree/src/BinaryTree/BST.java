package BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class BST<K extends Comparable<K>> extends BinTree<K>{
	/**
	 * find the target node in BST
	 * @param target 
	 * @return
	 */
	public BinNode<K> findNode(K target){
		if(root()==null)
			return null;
		return recuisiveFindNode((BinNode<K>) root(), target);
	}
	/*
	 * 如果树中不包含target，则返回 target的父节点
	 * 从node开始，找target
	 */
	@SuppressWarnings("unchecked")
	protected BinNode<K> recuisiveFindNode(BinNode<K> node, K target) {
		int comparison = target.compareTo(node.getData());
		if(comparison==0) return node;  //   node 就是要找的结点（target）
		if(comparison<0 && node.getLeft()!=null) // target比node小，则找node的左子结点
			return  recuisiveFindNode((BinNode<K>) node.getLeft(), target);
		if(comparison>0 && node.getRight()!=null)
			return  recuisiveFindNode((BinNode<K>) node.getRight(), target);
		return node;
	} 
	public void remove(K target) throws Exception{
		BinNode<K> n =findNode(target); //先找到位置
		if(n==null||!n.getData().equals(target)) throw new Exception("Target not present");
		removeNode(n); //method of BinaryNode
	}
	public void add(K newData) throws Exception{
		BinNode<K> node =findNode(newData); //位置
		if(node==null)
			addRoot(newData);
		else if((node.getData()).compareTo(newData) > 0) // node>newData,newData 放在左子树
			addLeft(node,newData);
		else if(node.getData().compareTo(newData) < 0)	
			addRight(node,newData);
		else node.setData(newData); //把newData放在node的位置
	}
	public boolean contains(K target) {
		BinNode<K> node = findNode(target);
		if(node==null||!node.getData().equals(target))
			return false;
		return true;
	}
	public boolean isEmpty() {
	      return root == null;
	   }
	public K get(K partialData) {
		BinNode<K> node = findNode(partialData);
		if(node==null||!node.getData().equals(partialData))
			return null;
		return node.getData();
	}
	public Iterator<K> iterator(){
		ArrayList<TNode> list = inOrder();
		ArrayList<K> dataList = new ArrayList<K>();
		for(TNode node: list)
			dataList.add(((BinNode<K>)node).getData());
		return dataList.iterator();
	}
	public void dumpData() {
	      System.out.println(treePrint(null));
	   }

@Override  // when removing from a BST, we can only promote from a neighbor in order
			//在中序遍历中，只需要调换 前面 结点的位置
	protected BinaryNode descendant(BinaryNode node) {
		 BinaryNode lower = node.getLeft(); //左儿子
		 if(lower !=null) { //左儿子不为空
			 while(lower.getRight()!=null) //左儿子的右儿子也不空时
				 lower = lower.getRight(); //指针后移
			 return lower;          //左儿子的右儿子
		 }
		 lower = node.getRight(); //右儿子
		 if(lower!=null) { // 右儿子不为空
			 while(lower.getLeft()!=null) //右儿子的左儿子不为空时
				 lower =lower.getLeft();  //指针后移
			 return lower;  //immediate successor of node (in order)
		 }
		 return null;
	}
	
}
