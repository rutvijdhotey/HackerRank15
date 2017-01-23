package binaryTrees;

import java.util.HashMap;

public class RebuildTreeFromInOrderAndPostOrder {
	public static TreeNode buildTree(int[] inorder, int[] postorder){
		HashMap<Integer,Integer> inorderMap = new HashMap<>();
	    for(int i = 0; i < inorder.length ; i++) inorderMap.put(inorder[i],i);
		return helper(0,inorder.length - 1,0,inorder.length - 1,inorder,postorder,inorderMap);
		}

		private static TreeNode helper(int poststart, int postend, int instart, int inend, int[] inorder, int[] postorder,HashMap<Integer,Integer> inorderMap) {
			if(postend > inorder.length - 1 || instart > inend){
				return null;
			}
			
			TreeNode root = new TreeNode(postorder[postend]);
			int inIndex = inorderMap.get(postorder[postend]);
			
			root.left = helper(poststart ,poststart + inIndex - instart - 1, instart, inIndex - 1, inorder,postorder,inorderMap);
			root.right = helper(poststart + inIndex - instart,postend - 1,inIndex + 1, inend,inorder,postorder,inorderMap);
			
			return root;
		}
}
