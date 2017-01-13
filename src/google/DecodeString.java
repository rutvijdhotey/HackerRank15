package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class DecodeString {

		public static String decodeString(String s){
			String res = "";
			ArrayList<Integer> aa = new ArrayList<>();
			Collections.reverse(aa);
			StringBuilder currentString = new StringBuilder();
			Stack<Integer> countStack = new Stack<Integer>();
			Stack<String> resStack = new Stack<String>();
			int index = 0;
			while(index < s.length()){
				if(Character.isDigit(s.charAt(index))){
					int count = 0;
					while(Character.isDigit(s.charAt(index))){
						count = 10 *  count + (s.charAt(index) - '0');
						index++;
					}
					countStack.push(count);
				} else if (s.charAt(index) == '['){
					resStack.push(res);
					res = "";
					index++;
				} else if (s.charAt(index) == ']'){
					int mult = countStack.pop();
					String repeat = resStack.pop();
					for(int i = 0 ; i < mult; i++){
						repeat += repeat;
					}
					res = repeat;
					index++;
				} else {
					res += s.charAt(index);
					index++;
				}
			}

			return res;
		}
}
