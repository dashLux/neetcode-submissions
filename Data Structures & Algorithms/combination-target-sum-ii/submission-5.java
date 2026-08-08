class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(candidates);
        backtrack(candidates, target, 0, curr, out);
        return out;
    }

    public void backtrack(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> out) {
        if (target == 0) {
            out.add(new ArrayList(curr));
            return;
        }

        if (target < 0) {
            return;
        }

        for(int j = start; j < candidates.length; j++) {
            if (j > start && candidates[j] == candidates[j-1]) {
                continue;
            }

            curr.add(candidates[j]);
            backtrack(candidates, target - candidates[j], j+1, curr, out);
            curr.removeLast();
        }
    }
}
