class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        int left = 0;
        int right = lower.length() - 1;

        while(left < right) {
            char l = lower.charAt(left);
            char r = lower.charAt(right);

            if (isAlphanumeric(l) && isAlphanumeric(r)) {
                if (l == r) {
                    left++;
                    right--;
                }
                else {
                    return false;
                }
            }
            else if (isAlphanumeric(l) && !isAlphanumeric(r)) {
                right--;
            }
            else {
                left++;
            }
        }

        return true;


    }

    private boolean isAlphanumeric(char c) {
        return ('A' <= c  && c <= 'Z') || ('a' <= c && c <= 'z') || ( '0' <= c && c <= '9');
    }
}
