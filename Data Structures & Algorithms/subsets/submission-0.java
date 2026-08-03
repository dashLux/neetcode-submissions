class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(nums, 0, curr, out);
        return out;
    
    }

    public void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> out) {
        if (start >= nums.length) {
            out.add(new ArrayList(curr));
            return;
        }

        curr.add(nums[start]);
        backtrack(nums, start+1, curr, out);

        curr.removeLast();
        backtrack(nums, start+1, curr, out);
    }



}
