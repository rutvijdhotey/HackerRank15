package binaryTrees;

public class RebuildFromInorderPostOrder {

	public static TreeNode buildTree(int[] inorder, int[] preorder){
		return helper(0,0,inorder.length - 1,inorder,preorder);
	}

	private static TreeNode helper(int prestart, int instart, int inend, int[] inorder, int[] preorder) {
		if(prestart > inorder.length - 1 || instart > inend){
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[prestart]);
		int inIndex = 0;
		for(int i = instart ; i < inend; i++){
			if(inorder[i] == preorder[prestart]){
				inIndex= i;
			}
		}
		
		root.left = helper(prestart + 1, instart, inIndex - 1, inorder,preorder);
		root.right = helper(prestart + inIndex - instart + 1,inIndex + 1, inend,inorder,preorder);
		
		return root;
	}
	
	
	

}
