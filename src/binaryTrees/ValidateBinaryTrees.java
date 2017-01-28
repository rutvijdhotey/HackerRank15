package binaryTrees;

public class ValidateBinaryTrees {
	public static boolean isValidBST(TreeNode root, Integer min, Integer max) {
		if(root == null) return true;
		
		if(min!= null && root.value <= min || max!= null && root.value >= max){
			return false;
		}
		
		if(!isValidBST(root.left,min,root.value) || !isValidBST(root.right,root.value,max)){
			return false;
		}
		
		return true;
	}
	
	public static boolean isValidBST(TreeNode root){
		if(root == null)  return true;
		return isValidBST(root,null,null);
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode left = new TreeNode(5);
		TreeNode right = new TreeNode(15);
		TreeNode n1 = new TreeNode(6);
		TreeNode n2 = new TreeNode(20);
		
		root.left = left;
		root.right = right;
		right.right = n2;
		right.left = n1;
		
		boolean ans = isValidBST(root);
		System.out.println(ans);
	}
}
