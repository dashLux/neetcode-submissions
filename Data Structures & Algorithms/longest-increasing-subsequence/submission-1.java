class Solution {
    public int lengthOfLIS(int[] nums) {
        // nums is empty -> return 0
        // nums has 1 element -> return 1

        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int maxLen = 1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }

        return maxLen;
    }
}
