class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            backtrack(nums, 0, i, curr, out);
        }
        return out;
    
    }

    public void backtrack(int[] nums, int start, int length, List<Integer> curr, List<List<Integer>> out) {
        if (curr.size() ==length ) {
            out.add(new ArrayList(curr));
            return;
        }

        for (int j = start; j < nums.length; j++) {
            curr.add(nums[j]);
            backtrack(nums, j+1, length, curr, out);
            curr.removeLast();
        }
    }
}
