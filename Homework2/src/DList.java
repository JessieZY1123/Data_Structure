
public class DList<T> {
	 private DNode<T> header, trailer;
	    private int size;
	    
	    public DList() {
	        size = 0;
	        header = new DNode<T>(null, null, null);
	        trailer = new DNode<T>(null, header, null);
	        header.setNext(trailer);
	    }
	    
	    public int size() {
	        return size;
	    }
	    
	    public boolean isEmpty() {
	        return size == 0;
	    }
	    
	    public DNode<T> getFirst(){
	        if(isEmpty()) return null;
	        return header.getNext();
	    }
	    
	    public DNode<T> getLast(){
	        if(isEmpty()) return null;
	        return trailer.getPrev();
	    }
	    
	    public DNode<T> getNext(DNode<T> v){
	        DNode<T> next = v.getNext();
	        if(next == null || next == trailer) return null;
	        return next;
	    }

	    public DNode<T> getPrev(DNode<T> v){
	        DNode<T> prev = v.getPrev();
	        if(prev == null || prev == header) return null;
	        return prev;
	    }
	    
	    //size changing methods.

	    //insert after DNode v    
	    public void insertAfter(T d, DNode<T> v) {
	        DNode<T> w = v.getNext();
	        DNode<T> x = new DNode<T>(d, v, w);
	        v.setNext(x);
	        w.setPrev(x);
	        size++;
	    }
	    
	    // insert before DNode v
	    public void insertBefore(T d, DNode<T> v) {
	        DNode<T> u = v.getPrev();
	        DNode<T> x = new DNode<T>(d, u, v);
	        u.setNext(x);
	        v.setPrev(x);
	        size++;
	    }
	    
	    public void addFirst(T d){
	        insertAfter(d, header);
	    }
	    
	    public void addLast(T d){
	        insertBefore(d, trailer);
	    }
	    
	    public T remove(DNode<T> v){
	        if(v == header || v == trailer) return null;
	        DNode<T> u = v.getPrev();
	        DNode<T> w = v.getNext();
	        u.setNext(w);
	        w.setPrev(u);
	        size--;
	        return v.getData();
	    }
	    
	    //List testing methods
	    public String toString() {
	        String ans = "";
	        DNode<T> h = header;
	        ans += "(H) <-> ";
	        do {
	            h = h.getNext();
	            if(h == trailer)
	                ans += "(T)";
	            else {
	                ans += h.getData();
	                ans += " <-> ";
	            }
	        } while( h!= trailer);
	        return ans;
	    }
}
