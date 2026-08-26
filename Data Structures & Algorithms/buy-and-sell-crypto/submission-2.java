class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int left = 0;
        int right = 0;

        while (right < prices.length) {
            if (prices[right] < prices[left]) {
                left = right;
            } 
            else {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            }
            right++;
        }

        return maxProfit;
    }
}
