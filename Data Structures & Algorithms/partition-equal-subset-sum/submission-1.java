class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int half = sum / 2;

        boolean[] dp = new boolean[half + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            for(int j = half; j >= curr; j--) {
                if (!dp[j-nums[i]]){
                    continue;
                }
                dp[j] = true;
                
            }
        }
        return dp[dp.length-1];
    }
}
