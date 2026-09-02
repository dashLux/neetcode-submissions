class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> out = new ArrayList<>();
        String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
        };

        if (digits.length() == 0) {
            return out;
        }

        backtrack(digits, 0, "", out, digitToChar);
        return out;
    }

    private void backtrack(String digits, int currDigit, String currStr, List<String> out, String[] digitToChar) {
        if (currStr.length() == digits.length()) {
            out.add(currStr);
            currStr = "";
            return;
        }

        String chars = digitToChar[digits.charAt(currDigit) - '0'];
        for(char c : chars.toCharArray()) {
            backtrack(digits, currDigit+1, currStr+c, out, digitToChar);
        }
    }
}
