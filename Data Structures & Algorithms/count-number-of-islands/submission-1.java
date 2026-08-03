class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        //Set<Pair<Integer, Integer>> visited = new HashSet<>();
        int islands = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    islands = islands + 1;
                }
            }
        }
        return islands;
    }

    public void bfs(char[][] grid, int r, int c) {
        Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        Pair<Integer, Integer> p = new Pair<>(r, c);
        grid[r][c] = '0';
        queue.addLast(p);

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> pos = queue.removeFirst();
            List<Pair<Integer, Integer>> directions = List.of(new Pair<>(0, 1), new Pair<>(0, -1), new Pair<>(-1, 0), new Pair<>(1, 0));
            for(Pair<Integer, Integer> dir : directions) {
                int rd = pos.getKey() + dir.getKey();
                int rc = pos.getValue() + dir.getValue();

                if (rd >= 0 && rd < grid.length && rc >= 0 && rc < grid[0].length && grid[rd][rc] == '1') {
                    grid[rd][rc] = '0';
                    queue.addLast(new Pair<>(rd, rc));
                }
            }
        }
    }
}
