class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] picked = new boolean[nums.length];
        backtrack(nums, out, curr, picked);
        return out;
    }

    private void backtrack(int[] nums,  List<List<Integer>> out, List<Integer> curr, boolean[] picked) {
        if (curr.size() == nums.length) {
            out.add(new ArrayList<>(curr));
            return ;
        }

        for(int i = 0; i < nums.length; i++) {
            if (picked[i]) {
                continue;
            }
            curr.add(nums[i]);
            picked[i] = true;
            backtrack(nums, out, curr, picked);
            curr.remove(curr.size() - 1);
            picked[i] = false;
        }
    }
}
