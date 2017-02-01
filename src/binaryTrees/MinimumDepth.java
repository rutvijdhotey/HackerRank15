package binaryTrees;

public class MinimumDepth {
	 public int minDepth(TreeNode root){
			if(root == null){
				return 0;
			}
			
			int left = 0;
			int right = 0;
			if(root.left != null){
				left = minDepth(root.left);
			}
			
			if(root.right != null){
				right = minDepth(root.right);
			}
			
			if(left == 0  || right == 0){
			    return left + right + 1;
			}
			
			return Math.min(left,right) + 1;
		}
}
