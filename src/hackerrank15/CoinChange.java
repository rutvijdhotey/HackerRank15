package hackerrank15;

import java.util.HashMap;
import java.util.Scanner;

public class CoinChange {
	
	//Given Coins and the amount needed to make with those coins. Count the number of ways we can do that
	//Classic Dynamic Programming problem
	
	public static long makeChange(int amount, int[] coins){
		return makeChange(amount,coins,0,new HashMap<String , Long>());
	}

	private static long makeChange(int amount, int[] coins, int index, HashMap<String, Long> memo) {
		if(amount == 0){
			return 1;
		}
		if(index >= coins.length) return 0;
		
		String key = amount + "-" + index;
		if(memo.containsKey(key)) return memo.get(key);
		
		int amountWithCoin = 0;
		long ways = 0;
		while(amountWithCoin <= amount){
			int rem = amount - amountWithCoin;
			ways += makeChange(rem,coins,index+1,memo);
			amountWithCoin += coins[index];
		}
		
		memo.put(key, ways);
		return ways;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int amount = scan.nextInt();
		int n = scan.nextInt();
		int[] coins = new int[n];
		for(int i = 0; i < n; i++){
			coins[i] = scan.nextInt();
		}
		
		scan.close();
		
		long ans = makeChange(amount,coins);
		System.out.println(ans);
		
	}
	
}
