class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backtrack(n, 0, 0, sb, out);
        return out;
    }

    public void backtrack(int n, int open, int close, StringBuilder sb, List<String> out) {
        if (open == n && close == n) {
            out.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backtrack(n, open+1, close, sb, out);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backtrack(n, open, close+1, sb, out);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
