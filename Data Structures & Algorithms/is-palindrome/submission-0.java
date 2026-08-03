class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        int left = 0;
        int right = lower.length() - 1;

        while(left <= right) {
            char l = lower.charAt(left);
            char r = lower.charAt(right);

            if (isValidChar(l) && isValidChar(r)) {
                if (l != r) {
                    return false;
                }
                left++;
                right--;
            }

            else if (isValidChar(l) && !isValidChar(r)) {
                right--;
            }
            else {
                left++;
            } 
        }
        return true;
    }

    public boolean isValidChar(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
