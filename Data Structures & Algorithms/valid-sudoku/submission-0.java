class Solution {
    public boolean isValidSudoku(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        boolean rowValid = checkRows(board);
        boolean colValid = checkCols(board);
        boolean boxValid = checkBoxes(board);

        return (rowValid && colValid) && boxValid;
    }

    public boolean checkRows(char[][] board) {
        for(int i = 0; i < 9; i++) {
            Set<Character> seen = new HashSet<>();
            char[] row = board[i];
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (seen.contains(c)) {
                    return false;
                }
                seen.add(c);
            }
        }
        return true;
    }

    public boolean checkCols(char[][] board) {
        for(int j = 0; j < 9; j++) {
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (seen.contains(c)) {
                    return false;
                }
                seen.add(c);
            }
        }
        return true;
    }

    public boolean checkBoxes(char[][] board) {
        for(int box = 0; box < 9; box++) {
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    int row = (box/3) * 3 + i;
                    int col = (box % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) {
                        return false;
                    }
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
