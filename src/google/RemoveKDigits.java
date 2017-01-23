package google;

import java.util.HashSet;

public class RemoveKDigits {
	public static String removeKdigits(String num, int k) {
        StringBuilder ans =  new StringBuilder();
        HashSet<Integer> list =  new HashSet<Integer>();
        int count = 0;
        for(int i = 1 ;i < num.length() && count < k; i++){
        	int num1 =num.charAt(i-1) - '0';
        	int num2 = num.charAt(i) - '0';
        	if(num1 > num2){
        		list.add(i-1);
        		count++;
        	} else if (num2 > num1){
        		list.add(i);
        		count++;
        	}
        }
        int i = 0;
        if(count < k) {
        	while(count < k){
        		if(list.contains(i)){
        			i++;
        		} else {
        			list.add(i);
        			count++;
        		}
        	}
        }
        
    	for(int n : list){
    		StringBuilder s = new StringBuilder(num);
    		s.deleteCharAt(n);
    		ans = s;
    	}
    	
    	return ans.toString();
       
    }
	
	public static void main(String[] args) {
		String s ="111112";
		int k = 3;
		String ans = removeKdigits(s,k);
		System.out.println(ans);
	}

}
