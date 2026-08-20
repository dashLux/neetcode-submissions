class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int swimInWater(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        //store [row, col, level] of a cell
        PriorityQueue<int[]> reachableLevel = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        boolean[][] visited = new boolean[rows][rows];

        reachableLevel.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        int ans = 0;

        while(!reachableLevel.isEmpty()) {
            int[] curr = reachableLevel.poll();
            ans = Math.max(ans, grid[curr[0]][curr[1]]);
            if (curr[0] == rows - 1 && curr[1] == rows - 1) {
                return ans;
            }
            for(int[] dir : directions) {
                int dr = curr[0] + dir[0];
                int dc = curr[1] + dir[1];
                if (dr < 0 || dc < 0 || dr >= rows || dc >= rows || visited[dr][dc]) {
                    continue;
                }
                int[] next = new int[]{dr, dc, grid[dr][dc]};
                reachableLevel.add(next);
                visited[dr][dc] = true;
            }
        }
        return -1;
    }
}
