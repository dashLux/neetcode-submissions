class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // 1. on every boarder cell, run dfs, if cell is "O", change it to "#"
        // 2. for every "O" cell that are not on the boarder, change it to "X"
        // 3. reverse cells previously changed to "#" back to "O"

        // 1. find boardering "O" cells and mark them as "#"
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    dfs(i, j, rows, cols, board);
                }
            }
        }

        //2. change "O" -> "X"
        for(int i  = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }


        //3. revers "#" to "O"
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int r, int c, int rows, int cols, char[][] board) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#';
        dfs(r+1, c, rows, cols, board);
        dfs(r-1, c, rows, cols, board);
        dfs(r, c+1, rows, cols, board);
        dfs(r, c-1, rows, cols, board);
     }
}
