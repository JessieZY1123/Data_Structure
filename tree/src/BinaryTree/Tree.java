package BinaryTree;
import java.util.ArrayList;
import java.util.Iterator;
public class Tree {
	protected TNode root;
	public int size;
	
	public Tree() {
		root = null;
		size = 0;
	}
	public TNode root() {
		return root;
	}
	/*
	 * get parent Node
	 */
	public TNode parent(TNode node) {
		return node.getParent();
	}
	public boolean isRoot(TNode node) {
		return node == root;
	}
	/*
	 * Internal node has children,then return true.
	 */
	public boolean isInternal(TNode node) {
		return node.children().hasNext();
	}
	public boolean isLeaf(TNode node) {
		return !isInternal(node);
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public int depth(TNode node) {
		if(isRoot(node)) return 0; //base case;
		return 1+depth(node.getParent());//recursion 先算parent的depth, 然后+1
	}
	public int height(TNode node) {
		if(isLeaf(node)) return 0;
		int maxChild =0;// ht of the child with the longest path down to a leaf
		Iterator<TNode> c = node.children(); //孩子的个数，是一个迭代器
		while(c.hasNext()) { //如果c不是leaf
			int hc = height(c.next());  //计算每个子节点的高度
			if(hc > maxChild) //每个比较
				maxChild = hc;
		}return maxChild +1;		
	}
	public int heightRoot() {
		if(root ==null) return -1;	//没有root的时候，是-1.
		return height(root);
	}
	/*
	 * 先写这个节点nodeOrder.add(node);再写这个结点的子节点
	 */
	
	public ArrayList<TNode> preOrder(){
		ArrayList<TNode> list = new ArrayList<>();
		perOrder(root(),list);//遍历整个树
		return list;
	}
	public void perOrder(TNode node, ArrayList<TNode> list) {
		if (node==null) return;
		list.add(node);//先print 父节点
		Iterator<TNode> x= node.children(); //x是一个跌点起，x里都是node的子节点
		while(x.hasNext()) { //如果x还有子节点。x.hasNext()x不止一个结点
			TNode m = x.next();  //m是node的子节点，
			perOrder(m,list);  // m这个结点的前序，并加进list这个列表里
		}
	}
	/*
	 * 先找这个结点的子节点，再写这个结点
	 */
	public  void postOrder(TNode node, ArrayList<TNode> list){
		if(node==null) return;
		Iterator<TNode> c = node.children(); //c 这个迭代器里都是node的子节点
		while(c.hasNext()) { //子节点不止一个
			TNode child = c.next();//child 是node的第一个子节点
			postOrder(child,list);
		}
		list.add(node);//添加父节点
	}		
		
	public ArrayList<TNode> postOrder(){
		ArrayList<TNode> list = new ArrayList<>();
		postOrder(root(),list);
		return list;		
	}
	/*
	 * level order
	 * null,1,null,2,3,null,4,5,null
	 */
	public ArrayList<TNode> levelOrder(){
		ArrayList<TNode> list = new ArrayList<>();
		list.add(null);//add null first
		if(root==null) return list;
		list.add(root);
		for(int i=0; i<list.size();i++) {
			TNode node=list.get(i);//return the index of counter node in list
			if(node == null) list.add(null);
			else {
				Iterator<TNode> iterator= node.children();
				while(iterator.hasNext()) {
					TNode child=iterator.next();
					list.add(child);
				}
			}
			}return list;
		}
//	public ArrayList<TNode> flatOrder(){
//		return preOrder();
//	}
	public String treePrint(TNode cursor) {//环形链表
		String list=" ";
		Iterator<TNode> lev = levelOrder().iterator();
		Iterator<TNode> pre = preOrder().iterator();
		lev.next();//skip first element, because the first element is null
		while(lev.hasNext()) {//按levelOrder的列表，后面有东西，就循环
			TNode node = lev.next();
			if(node ==null) {
				list = list+"\n ";
				pre = preOrder().iterator();//reset the preOrder
			}else {
				while(true) {
					boolean atCursor =false;
					TNode n = pre.next();
					if(n == cursor)
						atCursor = true;
					String s = n.printData();
					if(atCursor)
						s="*"+ s +"*";
					if(n==node) {
						list += s+" ";
						break;
					}else {
						for(int i =0;i<s.length();i++) {
							list+= ' ';
						}list +=' ';
					}
				}
			}
		}return list;
	}
	
}
