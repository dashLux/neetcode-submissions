class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> out = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        dfs(s, 0, curr, out);

        return out;


    }

    public void dfs(String s, int start, List<String> curr, List<List<String>> out) {
        if (start == s.length()) {
            out.add(new ArrayList(curr));
            return;
        }

        for(int j = start; j < s.length(); j++) {
            if (isPalindrome(s, start, j)) {
                curr.add(s.substring(start, j+1));
                dfs(s, j+1, curr, out);
                curr.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j) {
        int l = i;
        int r = j;
        while(l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }
        return true;
    }

}
