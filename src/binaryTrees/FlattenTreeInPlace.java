package binaryTrees;

public class FlattenTreeInPlace {

	//DID NOT UNDERSTAND A THING.........COPIED CODE....
	
	TreeNode prev = null;
	public void flatten(TreeNode root) {
		if(root == null){
			return;
		} else {
			flatten(root.right);
			flatten(root.left);
			root.right = prev;
			root.left = null;
			prev = root;
		}
	}

}
