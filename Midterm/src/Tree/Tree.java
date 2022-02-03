package Tree;

import java.util.ArrayList;

/*
 * public TNode parent(TNode node);
 * public boolean isRoot(TNode node);
 * public boolean isInternal(TNode node);
 * public boolean isLeaf(TNode node)
 * public int size()
 * public boolean isEmpty()
 * public int depth(TNode node)
 * public int height(TNode node)
 * public int heightRoot()
 * public ArrayList<TNode> preOrder()
 * public void perOrder(TNode node, ArrayList<TNode> list) 
 * public void postOrder(TNode node, ArrayList<TNode> list)
 * public ArrayList<TNode> postOrder()
 * public ArrayList<TNode> levelOrder()
 * public String treePrint(TNode cursor)
 */
public class Tree<T> {
	private TNode<T> root;
	int size;
	public Tree() {
		root =null;
		size=0;
	}
	public TNode<T> getRoot(){
		return root;
	}
	public TNode<T> getParent(TNode<T> node) {
		return node.getParent();
	}
	public boolean isRoot(TNode<T> node) {
		return node==root;
	}
	public boolean isInternal(TNode<T> node) {
		return node.children().hasNext();
	}
	public boolean isLeaf(TNode<T> node) {
		return !isInternal(node);
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	
	
	
	
	
	
}
