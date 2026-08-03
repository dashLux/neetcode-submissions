class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int top = 0;
        int bot = r - 1;
        

        while (top <= bot) {
            int row = top + (bot - top)/2;
            if (matrix[row][c-1] < target) {
                top = row + 1;
            }
            else if (matrix[row][0] > target) {
                bot = row -1;
            }
            else {
                break;
            }
        }

        if (!(top <= bot)) {
            return false;
        }

        //row is the target row, we do binary search in row
        int row = top + (bot - top)/2;
        int left = 0;
        int right = matrix[row].length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] > target) {
                right = mid - 1;
            }
            else if (matrix[row][mid] < target) {
                left = mid + 1;
            }
            else {
                return true;
            }
        }

        return false;
    }
}
