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

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        seenParent.put(0, -1);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            for(int neigh : adj.get(node)) {
                if (seenParent.get(node) == neigh) {
                    continue;
                }
                if (seenParent.containsKey(neigh)) {
                    return false;
                }

                stack.push(neigh);
                seenParent.put(neigh, node);
            }
        }

        return seenParent.size() == n;
    }
}
