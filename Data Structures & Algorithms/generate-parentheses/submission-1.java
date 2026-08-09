class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backtrack(n, out, sb, 0, 0);

        return out;
    }

    public void backtrack(int n, List<String> out, StringBuilder sb, int open, int close) {
        if (open == n && close == n) {
            out.add(sb.toString());
            return;
        }

        //try adding a open bracket if open count is less than n
        if (open < n) {
            sb.append("(");
            backtrack(n, out, sb, open+1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        // try adding a close bracket if close count is less than open
        if (close < open) {
            sb.append(")");
            backtrack(n, out, sb, open, close+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
