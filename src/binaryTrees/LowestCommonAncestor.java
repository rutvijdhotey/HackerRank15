package binaryTrees;

public class LowestCommonAncestor {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
        	return null;
        }
        
        if(p == root || q == root){
        	return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        if(left != null && p != left && q != left){
        	return left;
        }
        
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(right != null && p != right && q != right){
        	return right;
        }
        
        if(left != null && right !=null){
        	return root;
        } else if(root == left || root == right){
        	return root;
        } else {
        	return left == null ? right : left; 
        }
        
        
    }

}
