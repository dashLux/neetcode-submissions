class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            else {
                digits[i] = 0;
                carry = 1;
            }
        }
        int[] ret = new int[digits.length+1];
        ret[0] = carry;
        for(int i = 1; i < digits.length; i++) {
            ret[i]= digits[i-1];
        }
        return ret;
    }
}
