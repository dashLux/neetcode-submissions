class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> out = new HashSet<>();
        List<Integer> curr = new ArrayList<>(); 
        backtrack(nums, target, 0, curr, out);
        return new ArrayList(out);
    }


    public void backtrack(int[] nums, int target, int start, List<Integer> curr, Set<List<Integer>> out) {
        if (target == 0) {
            out.add(new ArrayList(curr));
            return;
        }

        if (target < 0) {
            return;
        }

        for(int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, target - nums[i], i, curr, out);
            curr.removeLast();
        }
     }
}
