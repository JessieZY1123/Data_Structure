package Sort;

public interface PriorityQueue<K extends Comparable<K>> {
	 public void add(K x) throws Exception;
	   public K removeMin() throws Exception;
	   public boolean isEmpty();
}
