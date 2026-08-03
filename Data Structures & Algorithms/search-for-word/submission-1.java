class Solution {
    int row;
    int col;
    Set<int[]> visited;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;

        visited = new HashSet<>();

        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int r, int c, int currLen, String word) {
        if  (currLen == word.length()) {
            return true;
        }
        int[] pos = new int[]{r, c};
        if (r < 0 || c < 0 || r >= row || c >= col
           ||word.charAt(currLen) != board[r][c]
           ||visited.contains(pos)) {
            return false;
           }
        char temp = board[r][c];
        board[r][c] = '*';
        boolean res = dfs(board, r+1, c, currLen+1, word)
                    ||dfs(board, r, c+1, currLen+1, word)
                    ||dfs(board, r-1, c, currLen+1, word)
                    ||dfs(board, r, c-1, currLen+1, word);
        board[r][c] = temp;
        return res;
    }
}
