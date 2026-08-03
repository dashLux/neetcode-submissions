class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(nums, curr, out);
        return out;

    }

    public void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> out) {
        if (curr.size() == nums.length) {
            out.add(new ArrayList(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i])) {
                continue;
            }
            curr.add(nums[i]);
            backtrack(nums, curr, out);
            curr.removeLast();
        }
    }
}
