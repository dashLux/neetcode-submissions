class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            set.add(n);
        }

        int maxLen = 0;
        for(int n : nums) {
            if (!set.contains(n - 1)) {
                //using n as the beginning of our sequence
                int count = 1;
                while (set.contains(n + 1)) {
                    count++;
                    n++;
                }
                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }
}

// nums: [2,20,4,10,3,4,5]
// set: [2, 20, 4, 10, 3, 5]


