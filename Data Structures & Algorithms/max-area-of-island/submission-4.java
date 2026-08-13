class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }


    private int dfs(int[][] grid, int r, int c) {
        //base case:
        // * if (r, c) is out of bound
        // * if (r, c) is not land
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 0;
        int area = dfs(grid, r+1, c) + dfs(grid, r-1, c) + dfs(grid, r, c+1) + dfs(grid, r, c-1);
        return 1 + area;
    }
}
