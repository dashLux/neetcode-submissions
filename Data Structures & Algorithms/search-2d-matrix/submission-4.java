class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0;
        int bot = row-1;
        int targetRow = -1;

        while (top <= bot) {
            int mid = top + (bot - top) / 2;
            int[] curr = matrix[mid];
            if (curr[0] > target) {
                bot = mid - 1;
            }
            else if (target > curr[col - 1]){
                top = mid+1;
            }
            else {
                targetRow = mid;
                break;
            }
        }

        int l = 0;
        int r = col - 1;
        if (targetRow < 0) {
            return false;
        }
        int[] search = matrix[targetRow];
        while (l <= r) {
            int mid  = l + (r - l) / 2;
            if (search[mid] == target) {
                return true;
            }
            if (search[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return false;
    }
}
