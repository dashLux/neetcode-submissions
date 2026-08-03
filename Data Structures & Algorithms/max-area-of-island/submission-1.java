class Solution {
    static final int[][] directions = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        for(int i = 0 ; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    public int bfs(int[][] grid, int r, int c) {
        Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        grid[r][c] = 0;
        queue.addLast(new Pair<>(r, c));
        int area = 1;

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.removeFirst();
            for (int[] dir : directions) {
                int dr = p.getKey() + dir[0];
                int dc = p.getValue() + dir[1];

                if (dr >= 0 && dr < grid.length && dc >= 0 && dc < grid[0].length && grid[dr][dc] == 1) {
                    grid[dr][dc] = 0;
                    queue.addLast(new Pair<>(dr, dc));
                    area = area + 1;
                }
            }
        }

        return area;
    }
}
