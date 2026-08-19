// compare each pair of word, find first different letter and establish order 
// with edge [larger letter -> smaller letter]

//each letter is a node, starting from letter with 0 indegree, perform kahn's algorithm to generate topological order of letters


class Solution {
    public String foreignDictionary(String[] words) {
        List<char[]> edges = new ArrayList<>();
        
        //generating edges
        for(int i = 1; i < words.length; i++) {
            String word1 = words[i-1];
            String word2 = words[i];
            int p1 = 0; int p2 = 0;
            while (p1 < word1.length() && p2 < word2.length()) {
                if (word1.charAt(p1) == word2.charAt(p2)) {
                    p1++;
                    p2++;
                }
                else {
                    //see a different character. word1's char should be less than
                    // word2's char. [c2 -> c1]
                    char[] pair = new char[]{word2.charAt(p2), word1.charAt(p1)};
                    edges.add(pair);
                    break;
                }
            }

            if(p1 == word1.length() && p2 < word2.length()) {
                continue;
            }
            if (p1 < word1.length() && p2 == word2.length()) {
                return "";
            }

        }

    Map<Character, Set<Character>> adj = new HashMap<>();

    // FIX: seed every letter that appears anywhere in the input, with an empty set,
    // BEFORE overlaying the edge-derived constraints
    for (String word : words) {
        for (char c : word.toCharArray()) {
            adj.putIfAbsent(c, new HashSet<>());
        }
    }

    for (char[] edge : edges) {
        char larger = edge[0];
        char smaller = edge[1];
        adj.get(smaller).add(larger);
    }
        Queue<Character> q = new LinkedList<>();
        for(char c : adj.keySet()) {
            if (adj.get(c).size() == 0) {
                q.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for(char ch : adj.keySet()) {
                Set<Character> neigh = adj.get(ch);
                if (neigh.contains(c)) {
                    neigh.remove(c);
                    if (neigh.size() == 0) {
                        q.offer(ch);
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
