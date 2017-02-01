package binaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MinimumHeightTrees {

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> ans = new ArrayList<>();
		if(edges.length == 0){
			return ans;
		}
		
		int MHT = Integer.MAX_VALUE;
		boolean[][] boolTable = new boolean[n][n];
		for(int[] edge : edges){
			boolTable[edge[0]][edge[1]] = true;
			boolTable[edge[1]][edge[0]] = true;
		}
		
		for(int i = 0 ; i< n; i++){
			boolTable[i][i] = true;
		}
		
		
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		
		for(int i = 0; i < n; i++){
			int minHeight = dfs(boolTable,i,0,new HashSet<Integer>());
			MHT = Math.min(MHT, minHeight);
			if(map.containsKey(minHeight)){
				map.get(minHeight).add(i);
			}
		}
		
		return map.get(MHT);
	}

	private static  int dfs(boolean[][] boolTable, int root,int height,HashSet<Integer> parents) {
		parents.add(root);
		for(int i = 0 ; i < boolTable.length ;i++){
			if(root != i && boolTable[root][i] && !parents.contains(i)){
				parents.add(i);
				int currentHeight = dfs(boolTable,i,height, parents);
				height = Math.max(height, currentHeight);
			}
		}
		return ++height;
	}

	public static void main(String[] args) {
		int[][] map = {{1,0},{1,2},{1,3}};
		int n = 4;
		
		List<Integer> ans = findMinHeightTrees(n,map);
	}
	
}
