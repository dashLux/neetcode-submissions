class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }

        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {
            int mid = l + (r - l) /2;
            if (mid > 1 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            if (mid < nums.length - 1 && nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            if (nums[mid] < nums[0]) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return 0;
    }
}
