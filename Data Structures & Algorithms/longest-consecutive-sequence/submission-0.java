class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set= new HashSet<>();

        int maxLen = 0;
        for (int n : nums) {
            set.add(n);
        }

        for(int n : nums) {
            //if doesn't exist n - 1 in the array -> start of sequence
            if (!set.contains(n - 1)) {
                int curr = 1;
                while (set.contains(n + 1)) {
                    curr++;
                    n++;
                }
                maxLen = Math.max(maxLen, curr);
            }
        }

        return maxLen;
    }
}
