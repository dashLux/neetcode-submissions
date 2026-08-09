class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        for(int length = 0; length <= nums.length; length++) {
            backtrack(nums, length, 0, curr, out);
        }

        return out;
    }

    public void backtrack(int[] nums, int length, int start, List<Integer> curr, List<List<Integer>> out) {
        if (curr.size() == length) {
            out.add(new ArrayList(curr));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            curr.add(nums[i]);
            backtrack(nums, length, i+1, curr, out);
            curr.removeLast();
        }
    }
}
