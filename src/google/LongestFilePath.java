package google;

import java.util.Stack;

public class LongestFilePath {

	
	 public int lengthLongestPath(String s) {
	        int maxLen = 0;
			String[] array = s.split("\n");
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(0);
			for(String one : array){
				int level = one.lastIndexOf("\t") + 1;
				while(level + 1 < stack.size()) stack.pop();
				
				int currLen = stack.peek() + one.length() - level + 1;
				stack.push(currLen);
				
				if(one.contains(".")){
					maxLen = Math.max(maxLen, currLen - 1);
				}
			}
			return maxLen;
    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
