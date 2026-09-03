class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }

            }
        }

        int t = 0;
        while(fresh > 0 && !q.isEmpty()) {
            System.out.println(fresh);
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] pos = q.poll();
                for(int[] dir : directions) {
                    int dr = pos[0] + dir[0];
                    int dc = pos[1] + dir[1];
                    if (dr < 0 || dr >= grid.length || dc < 0 || dc >= grid[0].length || grid[dr][dc] != 1) {
                        continue;
                    }

                    grid[dr][dc] = 2; //mark visited
                    fresh--;
                    q.offer(new int[]{dr, dc});
                }
            }
            t++;
        }

        //System.out.println(fresh);
        return fresh > 0 ? -1 : t;
        
    }
}
