package google;

import java.util.HashSet;

public class LongestPalindrome {

	public static int longestPalindrome(String S){
		int max = 0;
		HashSet<Character> ch = new HashSet<>();
		
		for(int i = 0 ; i < S.length() ; i++){
			if(ch.contains(S.charAt(i))){
				max++;
				ch.remove(S.charAt(i));
			} else {
				ch.add(S.charAt(i));
			}
		}
		
		
		return max;
	}
}
