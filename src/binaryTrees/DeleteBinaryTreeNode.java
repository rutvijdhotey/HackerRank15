package binaryTrees;

public class DeleteBinaryTreeNode {
	public TreeNode deleteNode(TreeNode root, int key) {

		if (root == null) {
			return null;
		}

		else if (root.value < key) {
			root.left = deleteNode(root.right, key);
		}

		else if (root.value > key) {
			root.right = deleteNode(root.left, key);
		} else {
			if (root.left != null && root.right == null) {
				return root.left;
			}

			else if (root.right != null && root.left == null) {
				return root.left;
			}

			TreeNode n = inOrderSuccessor(root.right);
			root.value = n.value;
			root.right = deleteNode(root.right, n.value);

			
		}
		return root;


	}

	public TreeNode inOrderSuccessor(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}

		return root;
	}
}
