class Solution {
    public int search(int[] nums, int target) {
        int minIndex = findMinIndex(nums);
        int leftSearch = binarySearch(nums, 0, minIndex - 1, target);
        int rightSearch = binarySearch(nums, minIndex, nums.length - 1, target);

        if (leftSearch == -1 && rightSearch == -1) {
            return -1;
        }

        return leftSearch == -1 ? rightSearch : leftSearch;
    }


    private int findMinIndex(int[] nums) {
        if (nums.length == 1 || nums[nums.length - 1] > nums[0]) {
            return 0;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (m > 1 && nums[m] < nums[m - 1]) {
                return m;
            }
            else if (m < nums.length - 1 && nums[m] > nums[m+1]) {
                return m+1;
            }
            else if (nums[m] > nums[0]) {
                l = m+ 1;
            }
            else {
                r = m-1;
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int begin, int end, int target) {
        int l = begin;
        int r = end;

        while(l <= r) {
            int m = l + (r - l) / 2;
            //System.out.println(m);
            if (nums[m] == target) {
                return m;
            }
            else if (nums[m] < target) {
                l = m + 1;
            }
            else {
                r = m-1;
            }
        }
        return -1;
    }
}
