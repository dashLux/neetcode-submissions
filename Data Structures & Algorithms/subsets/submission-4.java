class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        for(int i = 0; i <= nums.length; i++) {
            backtrack(nums, 0, i, out, curr);
        }
        return out;
    }

    private void backtrack(int[] nums, int start, int len, List<List<Integer>> out, List<Integer> curr) {
        if (curr.size() == len) {
            out.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, i+1, len, out, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
