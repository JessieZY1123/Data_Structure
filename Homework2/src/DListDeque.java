
public class DListDeque<T> implements Deque<T>{
	private DList<T> dlist;
	public DListDeque() {
		dlist = new DList<T>();//part(f)
	}
	public int size() {
		return dlist.size(); //part(g)
	}
	public boolean isEmpty() {
		return dlist.isEmpty();
	}
	public T first() {
		return dlist.getFirst().getData();
	}
	public T last() {
		return dlist.getLast().getData();//part(h)
	}
	public void addFirst(T x) {
		dlist.addFirst(x);
	}
	public void addLast(T x) {
		dlist.addLast(x); //part(i)
	}
	public T removeFirst() {
		return dlist.remove(dlist.getFirst()); //part(j)
	}
	public T removeLast() {
		return dlist.remove(dlist.getLast());
	}
	public String toString(){
		return dlist.toString();
	}
	public static void main(String[] args){
		DListDeque<Integer> d = new DListDeque<>();
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
