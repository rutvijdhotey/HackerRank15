package google;


public class AddStrings {

	public static String addStrings(String num1, String num2){
		int n1 = num1.length();
		int n2 = num2.length();
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();
		StringBuilder s = new StringBuilder();
		int goTill = Math.max(n1, n2);
		int carry = 0;
		for(int i = 0; i < goTill; i++){
			if(i < n1 && i < n2){
				int dig1 = num1.charAt(i) - '0';
				int dig2 = num2.charAt(i) - '0';
				int digAfterAdd = dig1 + dig2 + carry;
				if(digAfterAdd > 9){
					carry = 1;
					s.append(digAfterAdd%10);
				} else {
					carry = 0;
					s.append(digAfterAdd);
				}
			} else { 
				if (i < n1){
					int digAfterAdd = num1.charAt(i) - '0' + carry;
					if(digAfterAdd > 9){
						carry = 1;
						s.append(digAfterAdd%10);
					} else {
						carry = 0;
						s.append(digAfterAdd);
					}
				} else if (i < n2){
					int digAfterAdd = num2.charAt(i) - '0' + carry;
					if(digAfterAdd > 9){
						carry = 1;
						s.append(digAfterAdd%10);
					} else {
						carry = 0;
						s.append(digAfterAdd);
					}
				}
			} 
		}
		
		if(carry == 1){
			s.append(1);
		}
		
		return s.reverse().toString();
		
	}
}
