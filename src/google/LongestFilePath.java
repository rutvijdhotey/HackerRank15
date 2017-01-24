package google;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class LongestFilePath {

	
	public static int ssolution(int X) {
		String input = ""+X;       
        int max = Integer.MIN_VALUE;
        for(int i = 1;i<input.length();i++){           
            char t = (char) Math.max(input.charAt(i), input.charAt(i-1));
            String preString = "";
            String sufString = "";
            if(i> 1){
                preString = input.substring(0,i-1);
            }
            if(i < input.length()-1){
                sufString = input.substring(i+1,input.length());
            }
            int ret = Integer.parseInt(preString+t+sufString);
            max = Math.max(max, ret);
        }
        return max;
		
	}
        
	
	
	 public static int lengthLongestPath(String s) {
	        int maximumLength = 0;
	        int maxLen = 0;
	        //Split the path for line change
			String[] array = s.split("\n");
			//using Stack to keep track of the parent directory
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(0);
			for(String one : array){
				//Check for sublevels
				int level = one.lastIndexOf("\t") + 1;
				while(level + 1 < stack.size()) stack.pop();
				
				int currentLength = stack.peek() + one.length() - level + 1;
				stack.push(currentLength);
				//Check for Image files only. No need to check for other ones
				if(one.contains(".") && (one.contains("jpeg") || one.contains("png") || one.contains("gif"))){
					if(maximumLength < currentLength - 1){
						maximumLength = currentLength - 1;
						String[] two = one.split(" ");
						maxLen = two[two.length - 1].length();
					}
					
				}
			}
			return maximumLength - maxLen;
    }
	 
	 public int solution (String S) {
		    String[] array = S.split("\n");
		    int length_sum = 0;
		    for(int i = array.length - 1, spaces = 0; i >= 0; i--) {
		        if(array[i].contains("jpeg") || array[i].contains("gif") || array[i].contains("png"))
		            spaces = array[i].length() - array[i].trim().length();
		        if(!array[i].contains(".") && (array[i].length() - array[i].trim().length() + 1) == spaces) {
		            length_sum += array[i].trim().length() + 1;
		            spaces--;
		        }
		    }
		    return length_sum;
		} 
	 
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthLongestPath("dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n   file1.txt\ndir2\n file2.gif"));
	}

}
