class Solution {
    int[][] directions = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }

    private int bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        grid[r][c] = 0;
        int area = 1;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            for(int[] dir : directions) {
                int dr = pos[0] + dir[0];
                int dc = pos[1] + dir[1];

                if (dr < 0 || dr >= grid.length || dc < 0 || dc >= grid[0].length || grid[dr][dc] != 1) {
                    continue;
                }

                grid[dr][dc] = 0;
                q.offer(new int[]{dr, dc});
                area++;
            }
        }
        return area;
    }
}
