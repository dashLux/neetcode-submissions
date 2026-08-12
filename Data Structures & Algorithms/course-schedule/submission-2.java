class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new HashSet<>());
        }

        for(int[] prereq : prerequisites) {
            int from = prereq[1];
            int to = prereq[0];

            adj.get(to).add(from);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (adj.get(i).size() == 0) {
                q.offer(i);
            }
        }

        int processed = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            processed += 1;
            for(int i = 0; i < adj.size(); i++) {
                Set<Integer> prereq = adj.get(i);
                if (prereq.contains(course)) {
                    prereq.remove(course);
                    if (prereq.size() == 0) {
                        q.offer(i);
                    }
                }
            }
        }
        return processed == numCourses;
    }
}
