package google;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticOcean {
	
	 int[] aa = {0,1,0,-1};
	 int[] bb = {1,0,-1,0};
	 public List<int[]> pacificAtlantic(int[][] matrix) {
	     List<int[]> answerList = new ArrayList<>();
	     if(matrix.length == 0){
	         return answerList;
	     }
		 int m = matrix.length;
		 int n = matrix[0].length;
		 boolean[][] pacific = new boolean[m][n];
		 boolean[][] atlantic = new boolean[m][n];
		 
		 
		 //Horizontals
		 for(int i = 0; i < m ; i++){
			 dfs(matrix ,pacific, Integer.MIN_VALUE, i ,0);
			 dfs(matrix ,atlantic, Integer.MIN_VALUE, i,n-1);
		 }
		 
		 //Verticals
		 for(int i = 0; i < n; i++){
			 dfs(matrix,pacific, Integer.MIN_VALUE, 0 ,i);
			 dfs(matrix,atlantic, Integer.MIN_VALUE, m-1 ,i);
		 }
		 
		 for(int i = 0; i < m; i++){
			 for(int j = 0; j < n; j++){
				 if(pacific[i][j] && atlantic[i][j]){
					 int[] a = {i,j};
					 answerList.add(a);
				 }
			 }
		 }
		
		 return answerList;
	 }
	 
	 
	private void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
		if( x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y] || height > matrix[x][y]){
			return;
		}
			visited[x][y] = true;
		for(int i = 0; i < aa.length; i++){
			dfs(matrix,visited,matrix[x][y], x + aa[i] , y + bb[i]);
		}	
	}
}
