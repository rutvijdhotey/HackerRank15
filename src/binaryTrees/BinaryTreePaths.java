package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> ans = new ArrayList<String>();
		if (root != null)
			bTreePaths(root, "", ans);
		
		return ans;

	}

	private void bTreePaths(TreeNode root, String string, List<String> ans) {
		if(root.left == null && root.right == null) ans.add(string + root.value);
		if(root.left != null) bTreePaths(root.left,string + root.value + "->",ans);
		if(root.right != null) bTreePaths(root.right,string + root.value + "->",ans);
	}

}
