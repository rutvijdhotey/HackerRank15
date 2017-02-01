package leetCode;

public class StockPrice1 {

	public static int maxProfit(int[] prices) {

		if (prices.length <= 1) {
			return 0;
		}

		int maxProfit = 0;
		int buy = prices[0];
		int sell = buy;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > sell) {
				sell = prices[i];
			} else {
				maxProfit += sell - buy;
				buy = prices[i];
				sell = buy;
			}
		}

		maxProfit += sell - buy;
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 12, 14, 15, 9, 2, 12, 3, 4 };
		System.out.println(maxProfit(arr));
	}

}
