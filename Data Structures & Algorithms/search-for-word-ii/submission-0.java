class TrieNode {
    Map<Character, TrieNode> children;
    String word;

    public TrieNode() {
        this.children = new HashMap<>();
        this.word = null;
    }
}

class Solution {

    List<String> out = new ArrayList<>();
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                dfs(board, i, j, root);
            }
        }

        return out;

    }

    private void dfs(char[][] board, int r, int c, TrieNode root) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }

        char curr = board[r][c];
        if (curr == '#' || !root.children.containsKey(curr)) {
            return;
        }
        TrieNode next = root.children.get(curr);
        if (next.word != null) {
            out.add(next.word);
            next.word = null;
        }

        board[r][c] = '#';

        for(int[] dir : directions) {
            dfs(board, r+dir[0], c+dir[1], next);
        }

        board[r][c] = curr;

    }



    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode runner = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!runner.children.containsKey(c)) {
                    runner.children.put(c, new TrieNode());
                }
                runner = runner.children.get(c);
                if (i == word.length() - 1) {
                    runner.word = word;
                }
            }
        }
        return root;
    }
}
