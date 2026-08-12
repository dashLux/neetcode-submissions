class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {
            int from = prereq[1];
            int to = prereq[0];

            adj.get(from).add(to);
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int processed = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            processed += 1;
            for(int next : adj.get(course)) {
                if (--indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return processed == numCourses;
    }
}
