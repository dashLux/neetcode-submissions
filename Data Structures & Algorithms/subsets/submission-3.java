class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        for(int length = 0; length <= nums.length; length++) {
            backtrack(nums, 0, length, curr, out);
        }
        return out;
    }

    public void backtrack(int[] nums, int start, int length, List<Integer> curr, List<List<Integer>> out) {
        if (curr.size() == length) {
            out.add(new ArrayList(curr));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, i+1, length, curr, out);
            curr.removeLast();
        }
    }
}
