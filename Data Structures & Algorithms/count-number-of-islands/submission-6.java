class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int island = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    island++;
                }
                
            }
        }
        return island;
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        grid[r][c] = '0';

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for(int[] dir : directions) {
                int dr = pos[0] + dir[0];
                int dc = pos[1] + dir[1];
                if (dr < 0 || dr >= grid.length || dc < 0 || dc >= grid[0].length || grid[dr][dc] != '1') {
                    continue;
                }

                grid[dr][dc] = '0';
                q.offer(new int[]{dr, dc});
            }
        }
    }
}
