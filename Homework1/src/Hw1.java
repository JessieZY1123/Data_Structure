import java.io.File;
import java.util.Scanner;

public class Hw1 {

	public static void main(String[] args) {
		 String word;
		 System.out.println("Homework 1 by Ziyan Jiang.");
		try{
			 Scanner input = new Scanner(new File("input.txt"));
			 word = input.nextLine();
			    while(true) {	
			    	if(word.contains("print")) {
			    		String newWord=word.substring(word.indexOf("print")+5);
			    	System.out.println(newWord);			    		
			    	}
			    	word = input.nextLine();
			    if(word.contains("end")) {
			    	System.out.println(word);		
			    	input.close();
			    }
			} 
			    }catch (Exception e) {
			    	System.out.println();
		    }
		    

}
}
