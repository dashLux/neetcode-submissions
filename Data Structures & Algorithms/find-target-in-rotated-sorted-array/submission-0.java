class Solution {
    public int search(int[] nums, int target) {
        int minIndex = findMin(nums);

        int res1 = binarySearch(nums, 0, minIndex, target);
        int res2 = binarySearch(nums, minIndex, nums.length, target);

        if (res1 == -1 && res2 == -1) {
            return -1;
        }
        return res1 == -1 ? res2 : res1;
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        int l = left;
        int r = right - 1;

        while (l <= r) {
            int m = l + (r - l)/2;
            if (nums[m] == target) {
                return m;
            }
            else if (nums[m] > target) {
                r = m- 1;
            }
            else {
                l = m+1;
            }
        }
        return -1;
    }

    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[nums.length - 1] > nums[0]) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid > 1 && nums[mid] < nums[mid - 1]) {
                return mid;
            }
            else if (mid < nums.length - 1 && nums[mid+1] < nums[mid]) {
                return mid+1;
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
