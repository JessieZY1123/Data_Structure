package ItQueue;

import java.util.Iterator;
/*
 * ItQueue<T>继承了LinkedQueue实例化 Iterable<T>
 */
public class ItQueue<T> extends LinkedQueue implements Iterable<T> {
	
	public Iterator<T> iterator(){  //constructor 
		return new QueueIterator<>(list.head);//从头节点开始遍历
	}
	public String toString() {
        String ans = "ItQueue<T>: ";
        for (T x : this)
            ans += x + " ";
        return ans;
    }
    
    public static void main(String[] args) {
        ItQueue<Integer> q = new ItQueue<>();
        for (int i = 1; i <= 5; i++)
            q.enqueue(i);
        
        Iterator<Integer> it = q.iterator(); 
        while (it.hasNext())
            System.out.print(it.next() + ", "); //1, 2, 3, 4, 5, 
        System.out.println();

        for (Integer x : q)
            System.out.print(x + ", "); //1, 2, 3, 4, 5,
        System.out.println();

    }
}
