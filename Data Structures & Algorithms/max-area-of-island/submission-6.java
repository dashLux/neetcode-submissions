class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int[] area = new int[]{0};
                    dfs(grid, i, j, area);
                    max = Math.max(max, area[0]);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    private void dfs(int[][] grid, int r, int c, int[] area) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
            return;
        }

        area[0]++;
        grid[r][c] = 0;
        dfs(grid, r+1, c, area);
        dfs(grid, r-1, c, area);
        dfs(grid, r, c+1, area);
        dfs(grid, r, c-1, area);
        
    }
}
