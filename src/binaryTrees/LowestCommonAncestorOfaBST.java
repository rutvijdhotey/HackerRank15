package binaryTrees;

public class LowestCommonAncestorOfaBST {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null) return null;
       while((root.value - p.value) * (root.value - q.value) > 0){
    	   root = root.value > p.value ? root.left : root.right;
       }
       
       return root;
        
    }

}
