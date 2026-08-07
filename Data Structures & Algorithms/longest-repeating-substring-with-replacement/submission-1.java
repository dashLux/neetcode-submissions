// AAABBA, K=1 
// substring: substring.length() - getMaxFrequencyCharacter(substring) <= k


class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for(int right = left; right < s.length(); right++) {
            char curr = s.charAt(right);
            count.put(curr, count.getOrDefault(curr, 0) + 1);
            int currLen = right - left + 1;
            if (currLen - Collections.max(count.values()) <= k) {
                maxLen = Math.max(currLen, maxLen);
            }
            else {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
            }
        }
        return maxLen;
    }
}
