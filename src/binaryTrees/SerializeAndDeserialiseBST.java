package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeserialiseBST {
	private static final String SEP = ",";
	private static final String NULL = "null";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null)
			return NULL;
		// traverse it recursively if you want to, I am doing it iteratively
		// here
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while (!st.empty()) {
			root = st.pop();
			sb.append(root.value).append(SEP);
			if (root.right != null)
				st.push(root.right);
			if (root.left != null)
				st.push(root.left);
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	// pre-order traversal
	public TreeNode deserialize(String data) {
		if (data.equals(NULL))
			return null;
		String[] strs = data.split(SEP);
		Queue<Integer> q = new LinkedList<>();
		for (String e : strs) {
			q.offer(Integer.parseInt(e));
		}
		return getNode(q);
	}

	// some notes:
	// 5
	// 3 6
	// 2 7
	private TreeNode getNode(Queue<Integer> q) { // q: 5,3,2,6,7
		if (q.isEmpty())
			return null;
		TreeNode root = new TreeNode(q.poll());// root (5)
		Queue<Integer> samllerQueue = new LinkedList<>();
		while (!q.isEmpty() && q.peek() < root.value) {
			samllerQueue.offer(q.poll());
		}
		// smallerQueue : 3,2 storing elements smaller than 5 (root)
		root.left = getNode(samllerQueue);
		// q: 6,7 storing elements bigger than 5 (root)
		root.right = getNode(q);
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(5);

		root.left = left;
		root.right = right;
		right.right = n2;
		left.left = n1;

//		System.out.println(serialize(root));

	}
}
