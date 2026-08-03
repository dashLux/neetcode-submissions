class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        Map<Integer, Integer> seenParent = new HashMap<>();


        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        if (!dfs(0, -1, adj, visited)) {
            return false;
        }
        return visited.size() == n;
    }

    public boolean dfs(int node, int parent, List<List<Integer>> adj, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        for(int neigh : adj.get(node)) {
            if (neigh == parent) {
                continue;
            }

            if (!dfs(neigh, node, adj, visited)) {
                return false;
            }
        }

        return true;
    }
}
