class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        int[] out = new int[numCourses];
        int count = 0;

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites) {
            inDegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);

        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int finish = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            out[count++] = node;
            finish++;
            for(int neig: adj.get(node)) {
                inDegree[neig]--;
                if (inDegree[neig] == 0) {
                    q.add(neig);
                }
            }
        }
        if (finish == numCourses) {
            return out;
        }
        return new int[0];
    }
}
