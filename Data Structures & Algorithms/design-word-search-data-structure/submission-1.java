class Node {
    Map<Character, Node> children;
    boolean isWord;

    public Node() {
        this.children = new HashMap<>();
        this.isWord = false;
    }
}
class WordDictionary {
    Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node runner = root;
        for(char c : word.toCharArray()) {
            if (!runner.children.containsKey(c)) {
                runner.children.put(c, new Node());
            }
            runner = runner.children.get(c);
        }
        runner.isWord = true;
    }

    public boolean search(String word) {
        return dfs(0, root, word);

    }

    private boolean dfs(int start, Node root, String word) {
        Node runner = root;
        for(int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for(Node child : runner.children.values()) {
                    if (dfs(i+1, child, word)) {
                        return true;
                    }
                }
                return false;
            }
            else {
                if (!runner.children.containsKey(c)) {
                    return false;
                }
                runner = runner.children.get(c);
            }
        }
        return runner.isWord;
    }
}
