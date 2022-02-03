package PriorityQueue;
/*
 * PriorityQueue 的核心就是找到最大值和最小值
 * 利用 heap的数据结构，将最大值/最小值 放在root的位置（array[0]的位置），方便使用
 */
public interface PriorityQueue<K extends Comparable<K>> {
		
		public void addMin(K x) throws Exception;
	    public K removeMin() throws Exception;
	    
	    public void addMax(K x) throws Exception;
	    public K removeMax() throws Exception;

}

