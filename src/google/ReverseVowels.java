package google;

import java.util.HashSet;
import java.util.Stack;

public class ReverseVowels {

	public static String reverseVowels(String s){
		StringBuilder ans = new StringBuilder();
		HashSet<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		
		Stack<Character> st = new Stack<Character>();
		for(int i = 0 ; i < s.length(); i++){
			if(vowels.contains(s.charAt(i))){
				st.push(s.charAt(i));
			}
		}
		
		for(int i = 0; i < s.length() ; i++){
			if(vowels.contains(s.charAt(i))){
				ans.append(st.pop());
			} else {
				ans.append(s.charAt(i));
			}
		}
		
		

		
		
		return ans.toString();
		
		
	}
}
