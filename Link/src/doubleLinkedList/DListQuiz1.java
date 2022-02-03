package doubleLinkedList;

public class DListQuiz1<T> {
	 private DNode<T> header, trailer;
	 private int size;

	 public DListQuiz1() {
	 size = 0;
	 header = new DNode<T>(null, null, null);
	 trailer = new DNode<T>(null, header, null);
	 header.setNext(trailer);
	 }

	 /**
	 * Adds an element d to the linked list in between the given nodes.
	 * The given u and v should be neighboring each other prior to the call.
	 *
	 * @param u node just before the location where the new element is inserted
	 * @param v node just after the location where the new element is inserted
	 */
	 private void addBetween(T d, DNode<T> u, DNode<T> v) {
		 DNode<T> newNode =new DNode<T>(d,u,v);
		 u.setNext(newNode);
		 v.setPrev(newNode);
		 size++;
	 }
	 public void add(T d){
	 if (size==0) addBetween(d, header, trailer);
	 else if (size % 2 == 1) addBetween(d, header, header.getNext());
	 else addBetween(d, trailer.getPrev(), trailer);
	}

	 public String toString() {
			String ans = "";
			DNode<T> temp = header;
			ans += "(H)-->";
			do {
				temp = temp.getNext();
				if (temp == trailer)
					ans += "(T)";
				else {
					ans += temp.getData();
					ans += "<->";
				}
			} while (temp != trailer);
			return ans;
		}
	 public static void main(String[] args) {
	 DListQuiz1<Integer> dlist = new DListQuiz1<Integer>();
	 System.out.println(dlist); // PART(a)
	 for (int i=0; i < 3; i++)
		 dlist.add(i);
	 System.out.println(dlist); // PART(b)
	 }
	}
