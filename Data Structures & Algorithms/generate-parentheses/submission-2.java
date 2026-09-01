class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(n, out, sb, 0, 0);
        return out;
    }

    private void backtrack(int n, List<String> out, StringBuilder curr, int open, int close) {
        if (open == n && close == n) {
            out.add(curr.toString());
            return;
        }

        if (open < n) {
            //try to add a open parenthesis
            curr.append("(");
            backtrack(n, out, curr, open+1, close);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) { 
            // try adding a close parenthesis to match open count
            curr.append(")");
            backtrack(n, out, curr, open, close+1);
            curr.deleteCharAt(curr.length() - 1);

        }
    }
}
