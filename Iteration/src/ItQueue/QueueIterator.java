package ItQueue;

import java.util.Iterator;
/* 用链表
 * 实例化了Iterator的接口，重写了next(), hasNext(),remove()方法
 */
public class QueueIterator<T> implements Iterator<T> {
	private Node<T> current;

    public QueueIterator(Node<T> c) {
        current = c;
    }
    
    public T next() {
        T answer = current.getData();
        current = current.getNext();//指针后移
        return answer;
    }
    
    public boolean hasNext() {
        return current != null;
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
