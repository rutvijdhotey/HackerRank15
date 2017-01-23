package google;

public class CountOfRangeSum {
	
	public static class Range{
		long sumBefore;
		long sumAll;
		int number;
		
		public Range(int a , int b, int c){
			this.sumAll = a;
			this.sumBefore = b;
			this.number = c;
		}
	}
	
	 public int countRangeSum(int[] nums, int lower, int upper) {
		 if(nums.length == 0 || nums == null){
			 return 0;
		 }
		 
		 
		 long sumAll = 0;
		 long sumBefore = 0;
		 int num = 0;
		 Range current = new Range(nums[0],nums[0],nums[0]);
		 for(int i = 1; i < nums.length ; i++){
			 num = nums[i];
			 sumAll = current.sumAll + num;
			 sumBefore = current.number + num;
			 
			 
			 
			 
			 
		 }
		 
	 }
	

}
