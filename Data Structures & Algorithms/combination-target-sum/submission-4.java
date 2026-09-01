class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(nums, target, 0, curr, out);
        return out;
    }

    private void backtrack(int[] nums, int target, int start, List<Integer> curr, List<List<Integer>> out) {
        if (target == 0) {
            out.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0) {
            return;
        }

        for(int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, target - nums[i], i, curr, out);
            curr.remove(curr.size() - 1);
        }
    }
}
