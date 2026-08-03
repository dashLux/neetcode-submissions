class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        int land = 2147483647;
        int rows = grid.length;
        int cols = grid[0].length;


        Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    queue.addLast(new Pair<>(i, j));
                }
            }
        }

        if (queue.size() == 0) {
            return;
        }

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.removeFirst();
            int r = p.getKey();
            int c = p.getValue();
            for(int[] dir : directions) {
                int dr = r + dir[0];
                int dc = c + dir[1];
                if (dr < 0 || dr >= rows || dc < 0 || dc >= cols || grid[dr][dc] != land) {
                    continue;
                }
                queue.addLast(new Pair<>(dr, dc));
                grid[dr][dc] = grid[r][c] + 1;
            }
        }
    }
}
