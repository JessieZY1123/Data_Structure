package stack;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Stack;
/*
 * match the symbol of ( { [ ,and if they matched ,the stack will pop the matched one 
 */
public class BracMatch {
	public static void main(String[] args) {
		System.out.println("Enter input tokens separated by commas");
		Stack<String> stack = new Stack<String>();
		Scanner input = new Scanner(System.in);
		StringTokenizer stk = new StringTokenizer(input.next(),",");
		try {
			while(stk.hasMoreTokens()) {
				String st = stk.nextToken();
				if(openBrac(st)) stack.push(st); //push the symbol into stack
				if(closeBrac(st)) {
					if(stack.isEmpty()) throw new Exception("Mismatched"+ st);
					String c = (String) stack.pop(); //if they match ,then delete the symbol,c= stack.pop;
					System.out.println(c);
					if(! isMatched(c,st)) throw new Exception("Mismatched"+c+st);
				}
			}
			if(stack.isEmpty()) System.out.println("Brackets are paired.");
			else throw new Exception("Unmatched"+ stack.pop());
		}catch(Exception e){
			System.out.println("Error" + e);
		}
		input.close();
	}
	public static boolean openBrac(String x) {
		if(x.equals("(")||x.equals("{")||x.equals("[")) return true;
		return false;
	}
	public static boolean closeBrac(String x) {
		if(x.equals(")")||x.equals("}")||x.equals("]")) return true;
		return false;
	}
	public static boolean isMatched(String x, String y) {
		if(x.equals("(") && y.equals(")")) return true;
		if(x.equals("{") && y.equals("}")) return true;
		if(x.equals("[") && y.equals("]")) return true;
		return false;
	}
}
