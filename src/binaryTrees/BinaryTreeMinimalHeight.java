package binaryTrees;

public class BinaryTreeMinimalHeight {
	
	public static TreeNode BSTMinHeight(int[] nums){
		if(nums.length < 1){
			return null;
		}
		
		return BSTMinHeight(nums, 0 ,nums.length - 1);
	}

	private static TreeNode BSTMinHeight(int[] nums, int start, int end) {
		if(start > end){
			return null;
		}
		
		int mid = (start + end)/ 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = BSTMinHeight(nums,start,mid - 1);
		root.right = BSTMinHeight(nums,mid+1,end);
		
		return root;
	}

}
