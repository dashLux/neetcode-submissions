class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int match = 0;
        for(int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                match++;
            }
        }

        int left = 0;
        for(int right = s1.length(); right < s2.length(); right++) {
            if (match == 26) {
                return true;
            }

            //include the s2.charAt(right) character
            int index = s2.charAt(right) - 'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index]) {
                match++;
            }
            if (s1Count[index] + 1 == s2Count[index]) {
                match--;
            }
            
            //exclude the s2.charAt(left) character
            index = s2.charAt(left) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index]) {
                match++;
            }
            if (s1Count[index] - 1 == s2Count[index]) {
                match--;
            }
            left++;
        }
        return match == 26;
    }
}
