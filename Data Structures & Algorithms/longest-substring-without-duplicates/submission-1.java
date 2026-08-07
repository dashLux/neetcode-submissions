class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for(int right = left; right < s.length(); right++) {
            //keep expanding right until we see a repeating character
            if (set.contains(s.charAt(right))) {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            int currLen = right - left + 1;
            maxLen = Math.max(maxLen, currLen);
            set.add(s.charAt(right));
        }
        return maxLen;
    }
}
