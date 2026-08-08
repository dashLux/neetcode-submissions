// dp solution: using dp array where dp[i] -> longest increasing subsequence until i
// dp[i] = max(dp[j] + 1, dp[i]) for all j < i and nums[j] < nums[i] (all previous smaller numbers

//above dp solution only returns the length of longest valid subsequence. If we want to construct the actual array, we need another parents array to store the index of the previous element contributing to the longest subsequence. See construct() function

class Solution {
    public int lengthOfLIS(int[] nums) {
        // nums is empty -> return 0
        // nums has 1 element -> return 1

        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int[] dp = new int[nums.length];
        int[] parents = new int[nums.length];

        Arrays.fill(dp, 1);
        Arrays.fill(parents, -1);

        int maxLen = 1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parents[i] = j;
                        maxLen = Math.max(maxLen, dp[i]);
                    }
                }
            }
        }

        //construct the actual array
        List<Integer> construct = restore(nums, dp, parents, maxLen);
        for(int n : construct) {
            System.out.print(n);
            System.out.print(" ");
        }


        return maxLen;
    }
    

    private List<Integer> restore (int[] nums, int[] dp, int[] parents, int max) {
        List<Integer> res = new ArrayList<>();
        int index = -1;
        for(int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                index = i;
            }
        }

        while(index != -1) {
            res.add(nums[index]);
            index = parents[index];
        }
        Collections.reverse(res);

        return res;
    }
}
