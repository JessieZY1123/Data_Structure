package BinaryTree;

public class AVLNode<K extends Comparable<K>> extends BinNode<K> {
	public int leftChildHt, rightChildHt;
	public static int max(int x, int y) {
		if(x>y)
			return x;
		return y;
	}
	public int fixHt() {
		leftChildHt = rightChildHt = -1;
		  AVLNode<K> l = (AVLNode<K>) getLeft(); //l是左子节点
	      AVLNode<K> r = (AVLNode<K>) getRight();//r是右子节点
	      if (l != null)// 如果左子节点不为空
	          leftChildHt = 1 + max(l.leftChildHt, l.rightChildHt);//左子节点的高度 = 1+ max(l.左子节点高度，l.右子节点高度)
	      if (r != null)
	          rightChildHt = 1 + max(r.leftChildHt, r.rightChildHt);
	      if (leftChildHt > rightChildHt) //如果左子节点高度 > 右子节点高度
	          return leftChildHt;
	       return rightChildHt;  //返回最大的子节点高度
	}
	public AVLNode(AVLNode<K> parent, AVLNode<K> leftChild, AVLNode<K> rightChild, K d) {
	      super(parent, leftChild, rightChild, d);
	      fixHt(); //结点高度
	   }
}
