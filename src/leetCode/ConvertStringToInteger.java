package leetCode;

public class ConvertStringToInteger {
	public int myAtoi(String str) {
		int total = 0;
		int sign = 1;
		int index = 0;
		if(str.length() < 1){
			return 0;
		}
		
		while(str.charAt(index) == ' '){
			index++;
		}
		
		if(index < str.length() && str.charAt(index) == '+' || str.charAt(index) == '-'){
			sign = str.charAt(index) == '-' ? -1: 1;
			index++;
		}
		
		while(index <  str.length()){
			int dig = str.charAt(index) - '0';
			if(dig > 9 || dig < 0){
				break;
			}
			
			if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE%10 < dig){
				return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE ;
			}
			
			total = total * 10 + dig;
			index++;
		}
		
		return total * sign;
	}

}
