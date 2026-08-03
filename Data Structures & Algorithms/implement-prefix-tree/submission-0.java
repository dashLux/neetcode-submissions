class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}
class PrefixTree {
    TrieNode root;

    public PrefixTree() {
         this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (curr.children[j] == null) {
                curr.children[j] = new TrieNode();
            }
            curr = curr.children[j];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            int j = word.charAt(i)-'a';
            if (curr.children[j] == null) {
                return false;
            }
            curr = curr.children[j];
        }
        return (curr.isEnd);

    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            int j = prefix.charAt(i) - 'a';
            if (curr.children[j] == null) {
                return false;
            }
            curr = curr.children[j];
        }
        return true;
    }
}
