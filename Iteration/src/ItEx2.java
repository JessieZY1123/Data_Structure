import java.util.Iterator;
import java.util.Stack;

public class ItEx2 {
	public static void main(String[] args) {
		Stack<Integer> stk = new Stack<>();
		Stack<Integer> stk1 = new Stack<>();
		Stack<Integer> stk2 = new Stack<>();
	
	for (int i = 1; i <= 10; i++) stk.push(i);

	while (!stk.empty()){

	    if (stk.peek() % 2 == 0) stk1.push(stk.pop());

	    else stk2.push(stk.pop());

	}

	Iterator it = stk2.iterator();

	while (it.hasNext()){

	    int n = (int) it.next();

	    if (it.hasNext()) System.out.print(it.next()); // line A

	    else System.out.print(n);

	}
	}}
