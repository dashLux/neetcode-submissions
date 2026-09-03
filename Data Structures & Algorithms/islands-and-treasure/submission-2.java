class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        int inf = 2147483647;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int t = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] pos = q.poll();
                for(int[] dir : directions) {
                    int dr = pos[0] + dir[0];
                    int dc = pos[1] + dir[1];

                    if (dr < 0 || dr >= grid.length || dc < 0 || dc >= grid[0].length || grid[dr][dc] == -1) {
                        continue;
                    }

                    if (t < grid[dr][dc]) {
                        grid[dr][dc] = t;
                        q.offer(new int[]{dr, dc});
                    }
                }
            }
            t++;
        }
        
    }
}
