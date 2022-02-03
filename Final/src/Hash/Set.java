package Hash;

import java.util.Iterator;
/*
 * set 集合是一个没有重复元素的集合
 * HashSet 对集合的迭代顺序不做保证
 */
public interface Set<E> extends Iterable<E> {
	public int size();
    
    public boolean isEmpty();
    
    public boolean contains(E k);
    
    public E get(E k);
    
    public void add(E k) throws Exception;
    
    public void remove(E k) throws Exception;
    
    public Iterator<E> iterator();
    
    public void dumpData();

}
