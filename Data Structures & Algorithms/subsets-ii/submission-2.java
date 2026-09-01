class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++) {
            backtrack(nums, 0, out, curr, i);    
        }
        return out;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> out, List<Integer> curr, int length) {
        if (curr.size() == length) {
            out.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            curr.add(nums[i]);
            backtrack(nums, i+1, out, curr, length);
            curr.remove(curr.size() - 1);
        }
    }
}
