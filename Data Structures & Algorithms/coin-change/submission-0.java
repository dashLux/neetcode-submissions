class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1]; //dp[i] -> least number of coins to get to amount i
        Arrays.fill(dp, -1);

        dp[0] = 0;

        for(int i = 1; i <= amount; i++) {
            dp[i] = findMin(coins, dp, i);
        }
        
        return dp[dp.length - 1];
    }


    public int findMin(int[] coins, int[] dp, int i) {
        // compare each coin (j) --> dp[i-j], find the min then plus 1 (adding the current coin)

        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            if (i - coin >= 0 && dp[i-coin] != -1) {
                System.out.println(dp[i-coin]);
                min = Math.min(min, dp[i-coin]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : 1 + min;
    }
}
