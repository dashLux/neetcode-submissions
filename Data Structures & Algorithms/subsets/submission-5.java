class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        for(int len = 0; len <= nums.length; len++) {
            backtrack(nums, 0, len, curr, out);
        }

        return out;
    }

    private void backtrack(int[] nums, int start, int len, List<Integer> curr, List<List<Integer>> out) {
        if (curr.size() == len) {
            out.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, i + 1, len, curr, out);
            curr.remove(curr.size() - 1);
        }
    }
}
