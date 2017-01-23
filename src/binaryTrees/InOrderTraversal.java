package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		if (root == null) {
			return ans;
		}
		inorderTraversal(root,ans);
		return ans;

	}

	private void inorderTraversal(TreeNode root, List<Integer> ans) {
		if(root == null){
			return;
		} else {
			inorderTraversal(root.left,ans);
			ans.add(root.value);
			inorderTraversal(root.right,ans);
		}
	}

}
