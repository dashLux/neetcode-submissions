class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(nums, 0, target, curr, out);
        return out;
    }

    public void backtrack(int[] nums, int start, int target, List<Integer> curr, List<List<Integer>> out) {
        if (target == 0) {
            out.add(new ArrayList(curr));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, i, target - nums[i], curr, out);
            curr.removeLast();
        }
    }
}
