package leetCode;

public class BuySellStock {

	public int maxProfit(int[] prices) {
		int profit = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int n = prices.length;
		for(int i = 0; i < n; i++){
			
			if(min > prices[i]){
				min = prices[i];
			} else {
				if(prices[i] - min > profit){
					profit = prices[i] - min;
				}
			}
		}
		
		return profit;
	}
}
