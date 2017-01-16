package google;

public class LongestIncreasingPathInAMatrix {

	public static int[][] xxyy = {{0,1},{1,0},{-1,0},{0,-1}};
	public static int longestPath(int[][] matrix){
		int max = 1;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] cache = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				int len = dfs(matrix,cache,i,j,max);
				max = Math.max(len, max);
			}
		}
		
		return max;
		
	}

	private static int dfs(int[][] matrix, int[][] cache, int i, int j, int max) {
		if(cache[i][j] != 0){
			return cache[i][j];
		}
		
		
		int m = matrix.length;
		int n = matrix[0].length;
		max = 1;
		for(int[] xy : xxyy){
			int x = i + xy[0] ,y = j + xy[1];
			if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
			int len  = 1 + dfs(matrix,cache,x,y,max);
			max = Math.max(len,max);
		}
		cache[i][j] = max;
		
		return max;
	}
}
