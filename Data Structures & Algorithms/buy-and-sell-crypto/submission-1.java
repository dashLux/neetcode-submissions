class Solution {
    public int maxProfit(int[] prices) {
        

        //[10, 1, 20] profit = 10
        //.    ^.     profit = 19

        int left = 0;
        int right = 0;
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            }
            else {
                left = right;
            }
            right++;
        }

        return maxProfit;

    }
}
