package stack;

public class DlinkedDeque<T> implements Deque<T>{
	private doubleLinkedList<T> Dlist;
	
	public DlinkedDeque() {
		Dlist = new doubleLinkedList<T>();
	}
	  public int size() {
		  return Dlist.size;
	  }
	  public boolean isEmpty() {
		  return Dlist.isEmpty();
	  }
	  public T first() {
		  return  Dlist.getFirst().getData();
	  }
	  public T last() {
		  return Dlist.getLast().getData();
	  }
	  public void addFirst(T data) {
		 Dlist.addFirst(data);
	  }
	  public void addLast(T data) {
		  Dlist.addLast(data);
	  }
	  public T removeFirst() {
		  DNode<T> first = Dlist.getFirst();
		  return Dlist.remove(first);
	  }
	  public T removeLast(){
		  DNode<T> last = Dlist.getLast();
		  return Dlist.remove(last);
	  }
	  public String toString(){
			return Dlist.toString();
		}
		public static void main(String[] args){
			DlinkedDeque<Integer> d = new DlinkedDeque<>();
			d.addLast(5); //5
			d.addFirst(3);//3,5
			d.addFirst(7);//7.3.5
			System.out.println(d.size());
			System.out.println("first element of deque: " + d.first());// 7
			System.out.println(d.toString()); // 7 <-> 3 <-> 5
			System.out.println("last element of deque: " + d.last());//5
			d.removeFirst();
			System.out.println(d.toString()); //3,5
			d.removeLast();
			System.out.println(d.toString()); //  3	
		}
}
