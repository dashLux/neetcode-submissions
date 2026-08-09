class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(candidates, target, 0, curr, out);

        return out;
    }


    public void backtrack(int[] nums, int target, int start, List<Integer> curr, List<List<Integer>> out) {

        //base case
        if (target == 0) {
            out.add(new ArrayList(curr));
            return;
        }

        if (target < 0 ) {
            return;
        }

        for(int i = start; i < nums.length; i++) {
            //skip duplicate elements
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            curr.add(nums[i]);
            backtrack(nums, target - nums[i], i+1, curr, out);
            curr.removeLast();
        }
    }
}
