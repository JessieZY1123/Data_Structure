package BinaryTree;

public class AVLNode<K extends Comparable<K>> extends BinNode<K> {
	public int leftChildHt, rightChildHt; // 左右儿子的高度
	
	public static int max(int x, int y) {
	      if (x > y)
	         return x;
	      return y;
	   } 
	public int fixHt() {
		leftChildHt = rightChildHt = -1; //初始化
		AVLNode<K> left =(AVLNode<K>) getLeft();
		AVLNode<K> right =(AVLNode<K>) getRight();
		if(left !=null)
			leftChildHt = 1+ max(left.leftChildHt, left.rightChildHt);
		 if (right != null)
	         rightChildHt = 1 + max(right.leftChildHt, right.rightChildHt);
		 if (leftChildHt > rightChildHt)
	         return leftChildHt;  //左儿子高度大
	      return rightChildHt;
	}
	
	public AVLNode(AVLNode<K> parent, AVLNode<K> leftChild, AVLNode<K> rightChild, K d) {
	      super(parent, leftChild, rightChild, d);
	      fixHt();
	   }
}
