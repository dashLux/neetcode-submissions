class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    ans.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
                else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return new ArrayList(ans);
    }
}
