package binaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigZagLevel {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		Stack<TreeNode> one = new Stack<>();
		Stack<TreeNode> two = new Stack<>();

		if (root == null) {
			return ans;
		}

		one.push(root);
		while (!one.isEmpty() || !two.isEmpty()) {
			List<Integer> current = new ArrayList<>();

			while (!one.isEmpty()) {
				TreeNode currentNode = one.pop();
				if (currentNode != null) {
					if (currentNode != null && currentNode.left != null) {
						two.push(currentNode.left);
					}
					if (currentNode != null && currentNode.right != null) {
						two.push(currentNode.right);
					}
					current.add(currentNode.value);
				}
			}
			if (current.size() > 0) {
				ans.add(current);
				current = new ArrayList<>();
			}

			current = new ArrayList<>();
			while (!two.isEmpty()) {
				TreeNode currentNode = two.pop();
				if (currentNode != null) {
					if (currentNode != null && currentNode.right != null) {
						one.push(currentNode.left);
					}
					if (currentNode != null && currentNode.right != null) {
						one.push(currentNode.right);
					}
					current.add(currentNode.value);
				}
			}
			if (current.size() > 0) {
				ans.add(current);
				current = new ArrayList<>();
			}

		}

		return ans;
	}

}
