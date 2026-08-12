class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int islandCount = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
        
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        grid[r][c] = '0';

        while (!q.isEmpty()) {
            int[] p = q.poll();
            for(int[] dir : directions) {
                int dr = p[0] + dir[0];
                int dc = p[1] + dir[1];
                if (dr < 0 || dr > grid.length - 1 || dc < 0 || dc > grid[0].length - 1 || grid[dr][dc] != '1') {
                    continue;
                }
                q.offer(new int[]{dr, dc});
                grid[dr][dc] = '0';
            }
        }
    }
}
