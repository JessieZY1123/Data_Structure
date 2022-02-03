package tree;

import java.util.Iterator;
/*
 * 调用了TNode的接口。
 */

public interface TNode {
	public Iterator<TNode> children();//has two methods ---hasNext()/next()
	public TNode getParent();
	public String printData();
	
}
