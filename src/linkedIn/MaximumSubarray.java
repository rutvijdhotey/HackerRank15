package linkedIn;

public class MaximumSubarray {
	 public int maxSubArray(int[] array) {
	     	if(array.length == 0){
				return 0;
			}
			
			
			int maxSum = Integer.MIN_VALUE;
			int prevSum = Integer.MIN_VALUE;
			maxSum = 0;
			prevSum = maxSum;
		
			
			for(int i = 0; i < array.length; i++){
				if(array[i] < 0 && prevSum + array[i] > 0){
					prevSum = prevSum + array[i];
				} else if(prevSum + array[i] <= 0){
					prevSum = 0;
				} else {
					maxSum = Math.max(maxSum,prevSum + array[i]);
					prevSum = prevSum + array[i];
				}	
			}
		
			if(maxSum == 0){
				maxSum = array[0];
				for(int i = 1; i < array.length ; i++){
					maxSum = Math.max(maxSum,array[i]);
				}
			}
			
			return maxSum;
	    }
}
