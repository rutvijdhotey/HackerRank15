package binaryTrees;

public class ContainsTree {
	
	public boolean containsTree(TreeNode T1, TreeNode T2){
		if(T2 == null){
			return false;
		}
		
		return subTree(T1,T2);
	}

	private boolean subTree(TreeNode t1, TreeNode t2) {
		if(t2 == null || t2 == null){
			return false;
		}
		
		if(t1.value == t2.value && matchTree(t1,t2)){
			return true;
		}
		
		return subTree(t1.left , t2) || subTree(t1.right, t2);
	}

	private boolean matchTree(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null){
			return true;
		}
		
		if(t1 == null || t2 == null){
			return false;
		}
		
		if(t1.value != t2.value){
			return false;
		}
		
		return matchTree(t1.left, t2.left) && matchTree(t1.right,t2.right);
	}

}
