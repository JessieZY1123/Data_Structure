package stack;

public class LinkedStack<T> implements Stack<T> {
private LinkedList<T> list;
    
    public LinkedStack() {
        list = new LinkedList<>();
    }
    
    public int size() {
        return list.size();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public void push(T x) {
        list.addHead(x);
    }

    public T pop() {
        return list.removeHead();
    }
    
    public T top() {
        return list.head();
    }

    public String toString() {
        /**String answer = "LinkedStack<T>: ";
        Node<T> n = top;
        while( n != null) {
            answer += (n.getData() + " -> ");
            n = n.getNext();
        }**/
        return "LinkedStack<T>: " + list.toString();
    }
   
    public static void main(String[] args) {
        Stack<Integer> S = new LinkedStack<>();
        S.push(5);                              // contents: (5)
        S.push(3);                              // contents: (5, 3)
        System.out.println(S.size());           // contents: (5, 3)     outputs 2
        System.out.println(S.pop());            // contents: (5)        outputs 3
        System.out.println(S.isEmpty());        // contents: (5)        outputs false
        System.out.println(S.pop());            // contents: ()         outputs 5
        System.out.println(S.isEmpty());        // contents: ()         outputs true
        System.out.println(S.pop());            // contents: ()         outputs null
        S.push(7);                              // contents: (7)
        S.push(9);                              // contents: (7, 9)
        System.out.println(S.top());            // contents: (7, 9)     outputs 9
        S.push(4);                              // contents: (7, 9, 4)
        System.out.println(S.size());           // contents: (7, 9, 4)  outputs 3
        System.out.println(S.pop());            // contents: (7, 9)     outputs 4
        S.push(6);                              // contents: (7, 9, 6)
        S.push(8);                              // contents: (7, 9, 6, 8)
        System.out.println(S.pop());            // contents: (7, 9, 6)  outputs 8
        System.out.println(S);
       
    }
	
}
