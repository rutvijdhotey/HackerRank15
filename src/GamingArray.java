import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GamingArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int[] gamesArray = new int[n];
           
            for(int i = 0; i < n; i++){
            	gamesArray[i] = in.nextInt();
            }
            String winner = getWinner(gamesArray);
            System.out.println(winner);
        }
   	}

	private static String getWinner(int[] gamesArray) {
		String winner = "ANDY";
		
		Stack<Integer> stack =  new Stack<Integer>();
	    Stack<Integer> maxStack = new Stack<Integer>();   
	    for(int i = 0; i < gamesArray.length; i++){
	    	 stack.push(gamesArray[i]);
	    	 if(maxStack.isEmpty()){
	    		 maxStack.push(gamesArray[i]);
	    	 }else if(maxStack.peek() < gamesArray[i]){
	    		 maxStack.push(gamesArray[i]);
	    	 } 
	    }
	     
	    int turns = 0;
	    while(!stack.isEmpty()){
	    	int current_max = maxStack.pop();
	    	int stack_pop = 0;
	    	while(stack_pop!= current_max){
	    		stack_pop = stack.pop();
	    	}
	    	turns++;
	    }
		
	    if(turns%2 == 1){
	    	winner = "BOB";
	    }
		
		return winner;
	}

}
