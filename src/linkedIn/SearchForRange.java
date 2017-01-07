package linkedIn;

public class SearchForRange {
	
	public static int[] searchRange(int[] array, int target){
		int[] ans = {Integer.MAX_VALUE, -1};
		searchForRange(array,target,0,array.length -1, ans);
		if(ans[0] > ans[1]){
			ans[0] = -1;
			ans[1] = -1;
		}
		return ans;
	}

	private static void searchForRange(int[] array, int target, int left, int right, int[] ans) {
		if(left > right){
			return;
		}
		
		int mid = (left+right)/2;
		if(array[mid] == target){
			if(mid < ans[0]){
				ans[0] = mid;
				searchForRange(array,target,left,mid-1,ans);
			}
			if(mid > ans[1]){
				ans[1] = mid;
				searchForRange(array,target,mid+1,right,ans);
			}
		} else if(array[mid] > target){
			searchForRange(array,target,left,mid -1 ,ans);
		} else {
			searchForRange(array,target,mid,right,ans);
		}
	}

}
