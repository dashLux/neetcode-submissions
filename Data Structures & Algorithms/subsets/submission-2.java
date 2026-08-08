class Solution {
    public List<List<Integer>> subsets(int[] nums) {
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

        for(int j = start; j < nums.length; j++) {
            curr.add(nums[j]);
            backtrack(nums, length, j+1, curr, out);
            curr.removeLast();
        }
    }
}
