class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }


    private int bfs(int[][] grid, int r, int c) {
        int area = 0;
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {r, c});
        grid[r][c] = 0;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            area += 1;
            for(int[] dir : directions) {
                int dr = pos[0] + dir[0];
                int dc = pos[1] + dir[1];
                if (dr < 0 || dr >= grid.length || dc < 0 || dc >= grid[0].length || grid[dr][dc] != 1) {
                    continue;
                }
                grid[dr][dc] = 0;
                q.offer(new int[]{dr, dc});
            }
        }
        return area;
    }
}
