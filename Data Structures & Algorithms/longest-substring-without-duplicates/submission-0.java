class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxLen = 0;

        while(right < s.length()) {
            char r = s.charAt(right);
            freq.put(r, freq.getOrDefault(r, 0) + 1);

            while (freq.get(r) > 1) {
                char l = s.charAt(left);
                freq.put(l, freq.get(l)-1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
