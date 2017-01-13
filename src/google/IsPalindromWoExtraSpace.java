package google;

public class IsPalindromWoExtraSpace {

	
	 public static boolean isPalindrome(int x) {
	        int rev = 0;
	        int num = x;
	        while(num != 0){
	            rev = rev * 10 + num%10;
	            num = num/10;
	        }
	        
	        if((x ^ rev) == 0){
	        	return true;
	        }
	        return false;
	    }
	
	public static void main(String[] args){
		
		isPalindrome(1230);
		
	}
	
}
