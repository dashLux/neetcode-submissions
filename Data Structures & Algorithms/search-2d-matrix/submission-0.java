class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        for(int i = 0 ; i< r; i++) {
            boolean res = binarySearch(matrix[i], target);
            if (res){
                return true;
            }
        }
        return false;
    }


    public boolean binarySearch(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/ 2;
            if (row[mid] == target) {
                return true;
            }
            else if (row[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
}
