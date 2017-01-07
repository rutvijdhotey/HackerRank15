package linkedIn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializerBinaryTree {
	private static final String spliter = ",";
    private static final String NN = "X";
    
    public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
    }
  
	  public static String serializeTree(TreeNode root){
		  StringBuilder sb = new StringBuilder();
		  serializeTree(root,sb);
		  return sb.toString();
		  
		  
	  }

	private static void serializeTree(TreeNode root, StringBuilder sb) {
		if(root == null){
			sb.append(NN).append(spliter);
			return;
		} else {
			sb.append(root.val).append(spliter);
			serializeTree(root.left,sb);
			serializeTree(root.right,sb);
		}
	}
	
	private static TreeNode deserializeString(String s){
		Deque<String> nodes = new LinkedList<String>();
		nodes.addAll(Arrays.asList(s.split(spliter)));
		return deserializeTree(nodes);
		

	}

	private static TreeNode deserializeTree(Deque<String> nodes) {
		// TODO Auto-generated method stub
		String current = nodes.remove();
		if(current.equals(NN)){
			return null;
		} else {
			TreeNode node = new TreeNode(0);
			node.left = deserializeTree(nodes);
			node.right = deserializeTree(nodes);
			return node;
		}
	}
	 

}
