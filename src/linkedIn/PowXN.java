package linkedIn;

import java.util.HashMap;

public class PowXN {
	
	public static double powxn(double x, int n){
		HashMap<String, Double> set = new HashMap<String,Double>();
		return powxn(x,n,set);
	}

	public static double powxn(double x, int n,HashMap<String, Double> set){
		String key = Double.toString(x) + Integer.toString(n);

		
		if(set.containsKey(key)){
			return set.get(key);
		} 
		
		if(n == 0){
			return 1;
		} else if (n == 1){
			return x;
		} else if(n == -1){
			return 1/x;
		}
		
		double ans = x;
		
		boolean odd = false;
		if(n%2 == 1 && n > 0){
			n = n-1;
			odd = true;
		} else if(n%2 == -1 && n < 0) {
			n = n+1;
			odd = true;
		}
		
		
			ans = powxn(x,n/2,set) * powxn(x,n/2,set);
		
		
		
		
		if(odd && n < 0 ){
			ans = ans/x;
		} else if (odd && n > 0){
			ans = ans * x; 
		}
		
		set.put(key, ans);
		
		return ans;
	}
	
	public static void main(String[] args) {
		int n = 2;
		double x = 3.89707;
		
		System.out.println(powxn(x,n));
	}
}
