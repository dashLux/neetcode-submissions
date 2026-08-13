class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int LAND = 2147483647;
    int WATER = -1;
    int CHEST = 0;
    public void islandsAndTreasure(int[][] grid) {

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    bfs(grid, i, j);
                }
            }
        }
    }

    private void bfs(int[][] grid, int r, int c) {
        int dist = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int level = q.size();
            for(int l = 0; l < level; l++) {
                int[] pos = q.poll();
                for(int[] dir : directions) {
                    int dr = pos[0] + dir[0];
                    int dc = pos[1] + dir[1];
                    if (dr < 0 || dr >= grid.length || dc < 0 || dc >= grid[0].length || grid[dr][dc] == WATER || grid[dr][dc] == CHEST) {
                        continue;
                    }
            
                    if (dist < grid[dr][dc]) {
                        grid[dr][dc] = dist;
                        q.offer(new int[]{dr, dc});
                    }
                }
            }
            dist++;
        }
    }
}
