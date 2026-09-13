// b -> a

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        List<Integer> out = new ArrayList<>();

        for(int[] pre : prerequisites) {
            adj.computeIfAbsent(pre[1], v -> new HashSet<>()).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int course = q.poll();
            out.add(course);
            Set<Integer> nexts = adj.getOrDefault(course, new HashSet<>());
            for(int next : nexts) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        
        if (out.size() != numCourses) {
            return new int[]{};
        }

        int[] res = new int[numCourses];
        for(int i = 0; i < out.size(); i++) {
            res[i] = out.get(i);
        }

        return res;
    }
}
