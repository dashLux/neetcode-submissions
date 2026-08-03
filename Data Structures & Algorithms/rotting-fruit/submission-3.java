class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int minute = 0;
        int fresh = 0;
        Deque<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    //add rotten cell to queue
                    queue.addLast(new int[]{i, j});
                }
            }
        }

        while(fresh > 0 && !queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                int[] p = queue.removeFirst();
                for(int[] dir : directions) {
                    int dr = p[0] + dir[0];
                    int dc = p[1] + dir[1];
                    if (dr < 0 || dr >= row || dc < 0 || dc >= col || grid[dr][dc] != 1) {
                        continue;
                    }
                    grid[dr][dc] = 2;
                    fresh--;
                    queue.addLast(new int[]{dr, dc});
                }
            }
            minute = minute + 1;
        }
        return fresh == 0 ? minute : -1;
    }
}
