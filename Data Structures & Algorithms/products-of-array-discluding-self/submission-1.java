// prefix[i] -> product of everything before nums[i] (not including nums[i]!!!)

//same for suffix[i]

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];

        prefix[0] = 1;
        suffix[suffix.length - 1] = 1;

        //fill prefix and suffix array
        for(int i = 1; i < prefix.length; i++) {
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        for(int i = suffix.length - 2; i >= 0; i--) {
            suffix[i] = nums[i+1] * suffix[i+1];
        }

        //calculate out array by multiplying prefix[i] and suffix[i]

        int[] out = new int[len];
        for(int i = 0; i < out.length; i++) {
            out[i] = prefix[i] * suffix[i];
        }

        return out;
    }
}  
