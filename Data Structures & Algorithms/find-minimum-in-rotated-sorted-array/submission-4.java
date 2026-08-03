/**
    By observation, we see that if minimum element is at index i, then
        + nums[i-1] > nums[i]
    
    Using binary search, we can
        + if nums[mid] < nums[mid - 1] -> nums[mid] is the min
        + if nums[mid] > nums[mid+1] -> nums[mid+1] is the min


*/

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid > 1 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            else if (mid < nums.length - 1 && nums[mid+1] < nums[mid]) {
                return nums[mid+1];
            }
            else if (nums[mid] < nums[0]) {
                right = mid - 1;
            }
            else if (nums[mid] > nums[0]) {
                left = mid + 1;
            }
        }
        return 0;
    }
}
