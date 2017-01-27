package leetCode;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board.length < 2) {
			return;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if ((i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) && board[i][j] == 'O') {
					dfs(board, i, j);
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}

	}

	private void dfs(char[][] board, int i, int j) {

		board[i][j] = '*';
		int[][] dxdy = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		for (int[] xy : dxdy) {
			int dx = i + xy[0];
			int dy = j + xy[1];
			if (dx > 0 && dx < board.length && dy > 0 && dy < board[0].length && board[dx][dy] == 'O') {
				dfs(board, dx, dy);
			}
		}

	}
}
