class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> out = new ArrayList<>();
        String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
        };

        if (digits.length() == 0) {
            return out;
        }


        // backtrack(currAtDigit, currString, out)
        backtrack(digits, 0, "", out, digitToChar);
        return out;
    }

    public void backtrack(String digits, int currDigit, String currString, List<String> out, String[] digitToChar) {
        if (currString.length() == digits.length()) {
            out.add(currString);
            return;
        }
        String chars = digitToChar[digits.charAt(currDigit) - '0'];
        for(char c : chars.toCharArray()) {
            backtrack(digits, currDigit+1, currString+c, out, digitToChar);
        }
    }
}
