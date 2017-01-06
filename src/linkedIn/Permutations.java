package linkedIn;

public class Permutations {

	public static int maxSum(int[] array){
		
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
	
	public static void main(String[] args) {
		int[] array = {-1,6,7,-7,-2,-6,-1,3,4,2,6,-3,-8,-1,7};
		
		System.out.println(maxSum(array));
	}
}
