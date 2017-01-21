package google;

public class CountOfRangeSum {
	
	public static class Range{
		long sumBefore;
		long sumAfter;
		int number;
		
		public Range(int a , int b, int c){
			this.sumAfter = a;
			this.sumBefore = b;
			this.number = c;
		}
	}
	
	 public int countRangeSum(int[] nums, int lower, int upper) {
		 if(nums.length == 0 || nums == null){
			 return 0;
		 }
		 
		 
		 int sumAfter = 0;
		 int sumBefore = 0;
		 int num = 0;
		 Range = new Range(0,0,nums[0]);
		 for(int i = 0; i < nums.length ; i++){
			 
		 }
		 
	 }
	

}
