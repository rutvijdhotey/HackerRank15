package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		if (root == null) {
			return ans;
		}
		preorderTraversal(root,ans);
		return ans;

	}

	private void preorderTraversal(TreeNode root, List<Integer> ans) {
		if(root == null){
			return;
		} else {
			ans.add(root.value);
			preorderTraversal(root.left,ans);
			preorderTraversal(root.right,ans);
		}
	}
}
