// check each row contains duplicate 0-9
// check each column contains duplicate 0-9
// check each 3x3 box contains duplicate 0-9

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean row = checkRows(board);
        boolean col = checkCols(board);
        boolean box = checkBox(board);
        return row && col && box;
    }

    private boolean checkRows(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            Set<Character> seen = new HashSet<>();
            char[] row = board[i];
            for(char c : row) {
                if (c != '.' && seen.contains(c)) {
                    return false;
                }
                seen.add(c);
            }
        }
        return true;
    }

    private boolean checkCols(char[][] board) {
        for(int i = 0; i < board[0].length; i++) {
            Set<Character> seen = new HashSet<>();
            for(int j = 0; j < board.length; j++) {
                char c = board[j][i];
                if (c != '.' && seen.contains(c)) {
                    return false;
                }
                seen.add(c);
            }
        }
        return true;
    }

    //1 -> 0, 1, 2. 0, 1, 2
    //2-? 3,4,5,0

    private boolean checkBox(char[][] board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Set<Character> seen = new HashSet<>();
                for(int m = i * 3; m < (i+1) * 3; m++) {
                    for(int n = j * 3; n < (j+1) * 3; n++) {
                        char c = board[m][n];
                        if (c != '.' && seen.contains(c)) {
                            return false;
                        }
                        seen.add(c);
                    }
                }
            }
        }
        return true;
    }
}
