package binaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListOfEachDepth {
	
	public static List<List<TreeNode>> listofDepths(TreeNode root){
		List<List<TreeNode>> mainList = new ArrayList<>();
		if(root == null){
			return mainList;
		}
		
		List<TreeNode> current = new ArrayList<>();
		current.add(root);
		mainList.add(current);
		while(current.size() > 0){
			List<TreeNode> curr = new ArrayList<>();
			for(TreeNode parent : current){
				if(parent.left != null){
					curr.add(parent.left);
				}
				if(parent.right != null){
					curr.add(parent.right);
				}
			}
			mainList.add(curr);
			current = new ArrayList<>(curr);
		}
		
		return mainList;
	}
	
	public static List<List<Integer>> list(TreeNode root){
		List<List<TreeNode>> s = listofDepths(root);
		Stack<List<TreeNode>>  st= new Stack<>();
		for(List<TreeNode> one : s){
			st.push(one);
		}
		
		List<List<Integer>> ans = new ArrayList<>();
		while(!st.isEmpty()){
			List<TreeNode> curr = new ArrayList<>(st.pop());
			List<Integer> a = new ArrayList<>();
			for(TreeNode n : curr){
				a.add(n.value);
			}
			ans.add(a);
		}
		if(!ans.isEmpty())
			ans.remove(0);
		return ans;
	}

	
	public static void main(String[] args) {
		
	}
}
