class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // represent graph using adj list: u -> (v, t)
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for(int[] time: times) {
            edges.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // initialize min heap, putting in (0, k) -> distance = 0 from source node k
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();
        int t = 0;
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int dist = curr[0];
            int node = curr[1];
            if (visited.contains(node)) {
                // visited already, skip
                continue;
            }
            visited.add(node);
            t = dist;

            if (edges.containsKey(node)) {
                // find all neighbors of current node
                for(int[] edge : edges.get(node)) {
                    int nxtNode = edge[0];
                    int time = edge[1];
                    if (!visited.contains(nxtNode)) {
                        minHeap.offer(new int[]{dist+time, nxtNode});
                    }
                }
            }
        }

        return visited.size() == n ? t : -1;
    }
}
