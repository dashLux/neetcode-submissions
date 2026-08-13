/**
    for every boarding cell, if it is a O cell, we begin doing dfs on it (finding entire region that touches the boarder), while we discover new O cells along the dfs, we mark it as some other symbols

    after last step, all O regions touching the boarder should have been marked, so now all the remaining O cells or regions are not touching boarder. 

    so we can simply replace all of them with X

    at the end, we just need to mark the boarding O regions back to O(we marked them as another symbol earlier, remember?)
*/

class Solution {
    public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && isBoardering(i, j, board)) {
                    dfsAndMark(board, i, j);
                }
            }
        }

        //change all remaming O cells to X cell
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        //restore all # cell to O cell
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfsAndMark(char[][] board, int r, int c) {
        //base case
        // * out of bound
        // * X cell
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#';
        dfsAndMark(board, r+1, c);
        dfsAndMark(board, r-1, c);
        dfsAndMark(board, r, c-1);
        dfsAndMark(board, r, c+1);
    }

    private boolean isBoardering(int r, int c, char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        return (r == 0 || r == rows - 1 || c == 0 || c == cols - 1);
    }
}
