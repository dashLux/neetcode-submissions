class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for(int n : nums) {
            seen.add(n);
        }

        int max = 0;
        for(int n  : nums) {
            if (!seen.contains(n-1)) {
                int counter = 1;
                while (seen.contains(n+1)) {
                    counter++;
                    n++;
                }
                max = Math.max(max, counter);
            }
        }
        return max;
    }
}
