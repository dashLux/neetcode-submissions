class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            set.add(n);
        }

        int maxLen = 0;
        for(int n : nums) {
            if (set.contains(n-1)) {
                continue;
            }
            int curr = 1;
            while(set.contains(n+1)) {
                n += 1;
                curr++;
            }
            maxLen = Math.max(maxLen, curr);
        }
        return maxLen;
    }
}
