package linkedIn;

public class SearchInRotatedSortedArray {

	
	public int search(int[] array, int number){
		int lo = 0;
		int hi = array.length -1;
		
		while(lo < hi){
			int mid = (lo + hi)/2;
			if(array[mid] > array[hi]){
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		
		int pivotRotatedBy = lo;
		lo = 0;
		hi = array.length - 1;
		
		while(lo <= hi){
			int mid = (lo+hi)/2;
			int rotatedMid = (mid + pivotRotatedBy)% array.length;
			if(array[rotatedMid] == number){
				return rotatedMid;
			} else if(array[rotatedMid] > number) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		

	}

}
