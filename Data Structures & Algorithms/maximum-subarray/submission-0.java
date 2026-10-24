class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int n : nums) {
            if (currSum < 0) {
                currSum = n;
                maxSum = Math.max(maxSum, currSum);
                continue;
            }
            currSum += n;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
