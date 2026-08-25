// [1,2,4,6]

// [1,1,2,8]
// [48,24,6,1]

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = 1;
        suffix[suffix.length - 1] = 1;

        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
            suffix[nums.length - i - 1] = suffix[nums.length-i] * nums[nums.length-i];
        }

        int[] out = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            out[i] = prefix[i] * suffix[i];
        }

        return out;
    }
}  
