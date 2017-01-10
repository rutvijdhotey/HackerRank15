package linkedIn;

public class LowestCommonAncestor {
	
	 
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root == p || root == q || root == null){
	            return root;
	        } else {
	            TreeNode left = lowestCommonAncestor(root.left,p,q);
	            TreeNode right = lowestCommonAncestor(root.right,p,q);
	            if(left != null && right != null ){
	                return root;
	            } 
	            if(left == null){
	                return right;
	            } else {
	                return left;
	            }
	        }
	    }
}
