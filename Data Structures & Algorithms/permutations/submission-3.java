class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] picked = new boolean[nums.length];

        backtrack(nums, curr, out, picked);

        return out;
    }

    public void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> out, boolean[] picked) {
        if (curr.size() == nums.length) {
            out.add(new ArrayList(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if (picked[i]) continue;
            curr.add(nums[i]);
            picked[i] = true;
            backtrack(nums, curr, out, picked);
            curr.removeLast();
            picked[i] = false;
        }
    }
}
