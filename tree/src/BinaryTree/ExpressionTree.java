package BinaryTree;

import java.util.ArrayList;

public abstract class ExpressionTree extends BinaryTree {
	 public ExpressionTree() {
	      super();
	   }
	   public abstract String fullyParenthesised();
	   
	   public String postfix() {
	      String ans = "";
	      ArrayList<TNode> l = postOrder(); 
	      for (TNode b:l) ans += b.toString() + " ";
	      return ans;
	   }

	   public String prefix() {
	      String ans = "";
	      ArrayList<TNode> l = preOrder(); 
	      for (TNode b:l) ans += b.toString() + " ";
	      return ans;
	   }
}
