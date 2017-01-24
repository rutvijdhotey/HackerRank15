package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		if (root == null) {
			return ans;
		}

		rightSideView(ans, root,0);

		return ans;
	}

	private void rightSideView(List<Integer> ans, TreeNode root,int depth) {
		if (root == null) {
			return;
		}
		//To avoid adding the unnecessary nodes
		if(depth == ans.size()) ans.add(root.value);
		
		if (root.right != null) {
			rightSideView(ans, root.right,depth + 1);
		} 
		if (root.left != null) {
			rightSideView(ans, root.left,depth + 1);
			
		}

	}

}
