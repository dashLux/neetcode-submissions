class Solution {
    public String foreignDictionary(String[] words) {
      List<char[]> edges = new ArrayList<>();

      //process words pair by pair
      for(int i = 1; i < words.length; i++) {
        String word1 = words[i-1];
        String word2 = words[i];
        int p1 = 0;
        int p2 = 0;

        while (p1 < word1.length() && p2 < word2.length()) {
            if (word1.charAt(p1) == word2.charAt(p2)) {
                p1++;
                p2++;
            }
            else {
                //char at p1 of w1 should be smaller than char at p2 of w2
                //[c2, c1]
                char[] edge = new char[]{word2.charAt(p2), word1.charAt(p1)};
                edges.add(edge);
                break;
            }
        }

        //word1 is shorter than word2 -> valid 
        if (p1 == word1.length() && p2 < word2.length()) {
            continue;
        }
        //word1 is longer than word2 -> invalid input, return 
        if (p1 < word1.length() && p2 == word2.length()) {
            return "";
        }
      }

      Map<Character, Set<Character>> adj = new HashMap<>();

      for(String word : words) {
        for(char c : word.toCharArray()) {
            adj.computeIfAbsent(c, v -> new HashSet<>());
        }
      }

      //process edges and populate adj list
      for(char[] edge: edges) {
        char larger = edge[0];
        char smaller = edge[1];
        adj.get(smaller).add(larger);
      }

      //topological sort
      Queue<Character> q = new LinkedList<>();

      //enqueue all characters with 0 indegree
      for(char c : adj.keySet()) {
        if (adj.get(c).size() == 0) {
            q.offer(c);
        }
      }

      StringBuilder sb = new StringBuilder();
      while(!q.isEmpty()) {
        char curr = q.poll();
        sb.append(curr);
        for(char c : adj.keySet()) {
            Set<Character> neighs = adj.get(c);
            if (neighs.contains(curr)) {
                neighs.remove(curr);
                if (neighs.size() == 0) {
                    q.offer(c);
                }
            }
        }
      }

      if (sb.length() != adj.keySet().size()) {
        return "";
      }
      return sb.reverse().toString();
    }
}
