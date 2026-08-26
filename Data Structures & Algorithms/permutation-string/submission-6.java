class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        if (isMatch(s1Count, s2Count)) return true;


        int windowSize = s1.length();

        for(int right = windowSize; right < s2.length(); right++) {
            s2Count[s2.charAt(right) - 'a'] ++;
            s2Count[s2.charAt(right - windowSize) - 'a']--;
            if (isMatch(s1Count, s2Count)) return true;
        }
        return false;

    }


    private boolean isMatch(int[] s1Count, int[] s2Count) {
        for(int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) return false;
        }

        return true;
    }
}
