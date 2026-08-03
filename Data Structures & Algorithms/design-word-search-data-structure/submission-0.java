class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return dfs(0, root, word);
    }

    public boolean dfs(int start, TrieNode root, String word) {
        TrieNode curr = root;
        for(int i = start; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                //dfs
                for(TrieNode child : curr.children) {
                    if (child != null && dfs(i+1, child, word)) {
                        return true;
                    }
                }
                return false;
            }
            else {
                int j = word.charAt(i) - 'a';
                if (curr.children[j] == null) {
                    return false;
                }
                curr = curr.children[j];
            }
        }
        return curr.isEnd;
    }
}
