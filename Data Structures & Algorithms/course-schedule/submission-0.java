class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[0], v -> new ArrayList<>()).add(p[1]);
        }

        int[] state = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = fully processed

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, state)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> graph, int[] state) {
        if (state[course] == 1) return false; // currently being visited => cycle found
        if (state[course] == 2) return true;  // already fully processed, safe

        state[course] = 1; // mark as "in progress"
        for (int prereq : graph.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(prereq, graph, state)) {
                return false;
            }
        }
        state[course] = 2; // done, safe
        return true;
    }
}