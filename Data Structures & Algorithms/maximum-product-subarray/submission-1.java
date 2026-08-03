class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = 1;
        int curMin = 1;


        for(int n : nums) {
            int temp = n * curMax; 
            curMax = Math.max(n, Math.max(curMax * n, curMin * n));
            curMin = Math.min(n, Math.min(temp, curMin * n)); //temp is n*curMax
            res = Math.max(res, curMax);
        }

        return res;
    }
}
