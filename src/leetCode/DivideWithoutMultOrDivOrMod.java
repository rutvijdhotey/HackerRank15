package leetCode;

public class DivideWithoutMultOrDivOrMod {
	public static int divide(int dividend, int divisor) {
		long ans = divideLong(divisor, dividend);
		return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ans;
	}

	private static long divideLong(long divisor, long dividend) {
		
		boolean negative = false;
		if((divisor < 0 && dividend > 0) || (dividend < 0 && divisor > 0)){
			negative = true;
		}
		
		if (dividend < 0) dividend = -dividend;
		if (divisor < 0) divisor = -divisor;
		
		if(divisor > dividend){
		    return 0;
		}
		
		long sum = divisor;
		long ans = 1;
		while(sum + sum < dividend){
			sum += sum;
			ans += ans;
		}
		
		return negative ? -(ans + divideLong(divisor,dividend - sum)) : ans + divideLong(divisor, dividend - sum);
	}
	
	public static void main(String[] args) {
		System.out.println(divide(-1,1));
	}

}
