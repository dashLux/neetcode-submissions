class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(candidates, 0, target, out, curr);
        return out;
    }


    private void backtrack(int[] candidates, 
                           int start,
                           int target, 
                           List<List<Integer>> out,
                           List<Integer> curr
    ) {
        if (target == 0) {
            out.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0) {
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            curr.add(candidates[i]);
            backtrack(candidates, i+1, target - candidates[i], out, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
