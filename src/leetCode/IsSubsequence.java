package leetCode;

public class IsSubsequence {
	
	
	public static boolean isSubsequence(String s, String t){
		boolean ans = false;
		
		if(s.length() > t.length()){
			return ans;
		}
		
		int currIndex = 0;
		char currentChar = s.charAt(currIndex);
		for(int i = 0 ; i < t.length(); i++){
			char currentChartoCheck = t.charAt(i);
			if(currentChar == currentChartoCheck && t.length() - i >= s.length() - currIndex){
				currIndex++;
				if(currIndex == s.length()){
					ans = true;
					break;
				}
				currentChar = s.charAt(currIndex);
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(isSubsequence("Hi","Hello"));
	}

}
