package linkedIn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BTreeLevelOrderTraversal {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	public class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> mainList = new ArrayList<>();
	        if(root == null){
	            return mainList;
	        }
	        
	        LinkedList<LinkedList<TreeNode>> mainTrees = new LinkedList<>();
	        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
	        List<Integer> values = new ArrayList<Integer>();
	        
	        if(root!= null){
	            current.add(root);
	            values.add(root.val);
	        }
	        
	        while(current.size() > 0){
	            mainTrees.add(current);
	            mainList.add(values);
	            
	            LinkedList<TreeNode> parents = current;
	            values = new ArrayList<>();
	            current = new LinkedList<>();
	            
	            for(TreeNode parent : parents){
	                if(parent.left != null){
	                    values.add(parent.left.val);
	                    current.add(parent.left);
	                }
	                if(parent.right != null){
	                    values.add(parent.right.val);
	                    current.add(parent.right);
	                }
	            }
	        }
	        
	        return mainList;
	        
	        
	    }
	}
}
