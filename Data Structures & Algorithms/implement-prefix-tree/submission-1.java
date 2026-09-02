class Node {
    Map<Character, Node> children;
    boolean isWord;

    public Node() {
        this.children = new HashMap<>();
        this.isWord = false;
    }
}
class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node();

    }

    public void insert(String word) {
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
        Node runner = root;
        for(char c : word.toCharArray()) {
            if (!runner.children.containsKey(c)) {
                return false;
            }
            runner = runner.children.get(c);
        }
        return runner.isWord;

    }

    public boolean startsWith(String prefix) {
        Node runner = root;
        for(char c : prefix.toCharArray()) {
            if (!runner.children.containsKey(c)) {
                return false;
            }
            runner = runner.children.get(c);
        }
        return true;
    }
}
