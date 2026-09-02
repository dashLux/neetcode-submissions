class Node {
    Map<Character, Node> children;
    String word;

    public Node() {
        this.children = new HashMap<>();
        this.word = null;
    }
}
class Solution {
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> out = new ArrayList<>();
        Node root = buildTrie(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, out, root);
            }
        }
        return out;
    }

    private void dfs(char[][] board, int r, int c, List<String> out, Node root) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '&' || !root.children.containsKey(board[r][c])) {
            return;
        }

        char curr = board[r][c];
        Node next = root.children.get(curr);
        if (next == null) {
            return;
        }
        if (next.word != null) {
            out.add(next.word);
            next.word = null;
        }
        board[r][c] = '&';
        for(int[] dir : directions) {
            dfs(board, r+dir[0], c+dir[1], out, next);
        }
        board[r][c] = curr;
    }

    private Node buildTrie(String[] words) {
        Node root = new Node();
        for(String s : words) {
            Node runner = root;
            for(char c : s.toCharArray()) {
                if (!runner.children.containsKey(c)) {
                    runner.children.put(c, new Node());
                }
                runner = runner.children.get(c);
            }
            runner.word = s;
        }
        return root;
    }
}
