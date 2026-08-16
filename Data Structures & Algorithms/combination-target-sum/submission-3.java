class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        backtrack(nums, target, 0, comb, out);
        return out;
    }

    private void backtrack(int[] nums, int target, int start, List<Integer> comb, List<List<Integer>> out) {
        if (target == 0) {
            out.add(new ArrayList(comb));
        }

        if (target < 0) {
            return;
        }

        for(int i = start; i < nums.length; i++) {
            comb.add(nums[i]);
            backtrack(nums, target - nums[i], i, comb, out);
            comb.remove(comb.size() - 1);
        }
    }
}
