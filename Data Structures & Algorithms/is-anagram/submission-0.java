class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        Arrays.fill(freq, 0);

        if (s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < s.length(); i++) {
            //System.out.println(freq['r' - 'a']);
            if (freq[s.charAt(i) - 'a'] != 0) {
                return false;
            }
        }

        return true;
    }
}
