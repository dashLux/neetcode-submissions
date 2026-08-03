class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int components = 0;
        for(int node = 0; node < n; node++) {
            if (visited.contains(node) == false) {
                dfs(node, visited, adj);
                components++;
            }
        }

        return components;
    }

    public void dfs(int node, Set<Integer> visited, List<List<Integer>> adj) {
        visited.add(node);
        for(int neigh : adj.get(node)) {
            if (visited.contains(neigh) == false) {
                dfs(neigh, visited, adj);
            }
        }
    }
}
