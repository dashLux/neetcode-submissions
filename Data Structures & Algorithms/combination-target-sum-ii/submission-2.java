class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> out = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(candidates, 0, target, curr, out);

        return new ArrayList(out);

    }

    public void backtrack(int[] candidates, int start, int target, List<Integer> curr, Set<List<Integer>> out) {
        if (target == 0) {
            out.add(new ArrayList(curr));
            return;
        }

        if (target < 0) {
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            else if (candidates[i] > target) {
                break;
            }
            else {
                curr.add(candidates[i]);
                backtrack(candidates, i+1, target - candidates[i], curr, out);
                curr.removeLast();
            }
            
        }
    }
}
