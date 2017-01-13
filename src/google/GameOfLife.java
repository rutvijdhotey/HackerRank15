package google;

public class GameOfLife {
	 public void gameOfLife(int[][] board) {
	        if(board == null || board.length == 0) return;
	        int m = board.length ;
	        int n = board[0].length;
	        
	        for(int i = 0; i < m; i++){
	            for(int j= 0; j < n; j++){
	                int lives = getLivesforPos(board,m,n,i,j);
	                
	                //For keeping them alive
	                if(board[i][j] == 1 && lives >= 2 && lives <= 3){
	                    board[i][j] = 3;
	                }
	                
	                //For Making them alive
	                if(board[i][j] == 0 && lives == 3 ){
	                    board[i][j] = 2;
	                }
	            }
	        }
	        
	        for(int i = 0; i < m; i++){
	            for(int j = 0 ; j < n; j++){
	                board[i][j] >>= 1;
	            }
	        }
	        
	        
	    }
	    
	    public int getLivesforPos(int[][] board, int m, int n, int i, int j){
	        int lives = 0;
	        for(int r = Math.max(i-1,0); r <= Math.min(i+1,m-1); r++){
	            for(int c = Math.max(j-1,0); c <= Math.min(j+1,n-1); c++){
	                System.out.println("r" + r +" " + "c "+ c);
	                lives += board[r][c] & 1;
	            }
	        }
	        
	        lives -= board[i][j] & 1;
	        return lives;
	    }

}
