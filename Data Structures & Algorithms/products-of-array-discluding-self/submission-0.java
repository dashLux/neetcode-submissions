class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];

        int prefix = 1;
        for(int i = 0; i < nums.length; i++) {
            out[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for(int j = nums.length - 1; j > -1 ; j--) {
            out[j] *= postfix;
            postfix *= nums[j];
        }
        return out;
    }
    
}  
