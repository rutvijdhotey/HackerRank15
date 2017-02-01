package leetCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class StockPriceKTransactions {

	public static int maxProfit(int[] prices) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(prices.length / 2, Collections.reverseOrder());
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
				// maxProfit += sell - buy;
				heap.add(sell - buy);
				buy = prices[i];
				sell = buy;
			}
		}

		heap.add(sell - buy);
		maxProfit = heap.poll() + heap.poll();

		return maxProfit;
	}

	public static void main(String[] args) {
		int[] arr = { 1,2,4,2,5,7,2,4,9,0 };
		System.out.println(maxProfit(arr));
	}
}
