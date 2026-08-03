class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

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
            finish++;
            for(int neig: adj.get(node)) {
                inDegree[neig]--;
                if (inDegree[neig] == 0) {
                    q.add(neig);
                }
            }
        }
        return finish == numCourses;
    }
}
