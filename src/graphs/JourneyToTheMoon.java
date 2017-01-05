package graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class JourneyToTheMoon {

	public static void main(String[] args) throws Exception {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bfr.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int I = Integer.parseInt(temp[1]);

		int[][] dfsArray = new int[N][N];

		//Set all the same elements from the same country
		//for (int i = 0; i < N; i++) {
			//dfsArray[i][i] = 1;
		//}

		for (int i = 0; i < I; i++) {
			temp = bfr.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			// Store a and b in an appropriate data structure of your choice
			
			dfsArray[a][b] = 1;
			dfsArray[b][a] = 1;
		}
		
		//Now we have our NXN array with all the islands form..
		//Sue DFS to count the Islands
		int count = 0;
		long currentComb = 1;
		for(int row  = 0 ; row < dfsArray.length; row++){
			for(int column = 0; column< dfsArray[row].length ; column++){
				if(dfsArray[row][column] == 1){
					count++;
					HashSet<Integer> set = new HashSet<Integer>();
					getRegionDfs(dfsArray,row,column,set);
					currentComb *= set.size();
				}
			}
		}
		

		long combinations = currentComb;

		// Compute the final answer - the number of combinations

		System.out.println(combinations);
	}
	
	public static void getRegionDfs(int[][] matrix, int row, int column,HashSet<Integer> set){
		if(row < 0 || column < 0 || row >=  matrix.length || column >= matrix[row].length){
			return ;
		}
		
		if(matrix[row][column] ==  0){
			return ;
		}
		if(!set.contains(row)){
			set.add(row);
		}
		matrix[row][column] = 0;
		
		for(int i = row-1 ; i <= row+1 ; i++){
			for(int j = column-1 ; j <= column+1 ; j++){
				if(i != row || j != column){
					getRegionDfs(matrix,i,j,set);
				}
			}
		}
		
		return;
		
	}

}
