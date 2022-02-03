package Tree;

import java.util.Iterator;
/*
 * 
 */

public interface TNode<T> {
		public Iterator<TNode> children();//has two methods ---hasNext()/next()
		public TNode<T> getParent();
		public String printData();
		
	
}
