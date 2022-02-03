package stack;

import java.util.Deque;

public class Midjob<T> {

	    public static void main(String [] args) {

	        Stack<Integer>  stk1  = new LinkedStack  <Integer>  ();

	        Stack<Integer>  stk2  = new LinkedStack    <Integer> ();

	        stk1.push(5);

	        stk1.push(4);

	        stk2.push(3);

	        stk2.push(2);

	        stk2.push(1);
	        auxiliary( stk2,stk1);
	        

	    }
	    public static Stack<Integer> auxiliary(Stack<Integer> stk2,Stack<Integer> stk1){
	    	Deque<Integer> d = (Deque<Integer>) new DlinkedDeque<Integer>();//这里需要一个linkedlist 来实例化Deque
	    	if(stk2.isEmpty()) return stk1;
	    	while(!stk2.isEmpty()) {
	    		d.addLast(stk2.pop());
	    	}
	    	stk1.push(d.removeLast());
	    	return stk1;
	    }
	    

	}
