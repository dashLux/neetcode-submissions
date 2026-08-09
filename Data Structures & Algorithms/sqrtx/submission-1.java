class Solution {
    public int mySqrt(int x) {
        

        int left = 0; 
        int right = x;
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left)/2;
            long midSquare = (long)mid * mid;
            if (midSquare == x) {
                return mid;
            }
            if (midSquare < x) {
                left = mid + 1;
                res = mid;
            }
            else {
                right = mid - 1;
            }
        }
        return res;
    }
}