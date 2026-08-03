class Solution {
    int[][] directions = new int[][]{{0, 1},{0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        //pacific reachable
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    queue.addLast(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cell = queue.removeFirst();
            int r = cell[0];
            int c = cell[1];
            pacificReachable[r][c] = true;

            for(int[] dir : directions) {
                int dr = r + dir[0];
                int dc = c + dir[1];
                if (dr >= 0 && dr < rows && dc >= 0 && dc < cols && !pacificReachable[dr][dc] && heights[dr][dc] >= heights[r][c]) {
                    queue.addLast(new int[]{dr, dc});
                }
            }
        }

        //atlantic reachable
        Deque<int[]> atlanticQueue = new ArrayDeque<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (i == rows - 1 || j == cols - 1) {
                    atlanticQueue.addLast(new int[]{i, j});
                }
            }
        }

        while(!atlanticQueue.isEmpty()) {
            int[] cell = atlanticQueue.removeFirst();
            int r = cell[0];
            int c = cell[1];
            atlanticReachable[r][c] = true;

            for(int[] dir : directions) {
                int dr = r + dir[0];
                int dc = c + dir[1];
                if (dr >= 0 && dr < rows && dc >= 0 && dc < cols && !atlanticReachable[dr][dc] && heights[dr][dc] >= heights[r][c]) {
                    atlanticQueue.addLast(new int[]{dr, dc});
                }
            }
        }

        //find intersection of two reachable matrices

        List<List<Integer>> out = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    out.add(Arrays.asList(i, j));
                }
            }
        }

        return out;
    }
}
