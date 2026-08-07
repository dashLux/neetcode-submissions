// keep a window of size = s1.length()

//use the window to scan through s2, and for each segment, we check if segment is a permutation of s1 by counting frequencies of character

//time: O(Sn) -> S: s1.length(), n: s2.length


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        
        for(char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0)+1);
        }

        int left = 0;
        while (left <= s2.length() - s1.length()) {
            int right = left + s1.length(); //substring() is right-exclusive
            String temp = s2.substring(left, right);
            if (isPermutation(s1Map, temp)) {
                return true;
            }
            left += 1;
        }
        return false;
    }

    public boolean isPermutation(Map<Character, Integer> s1Map, String temp) {
        Map<Character, Integer> tempMap = new HashMap<>();
        for (char c : temp.toCharArray()) {
            tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
        }

        for(Character s1Char : s1Map.keySet()) {
            if (!tempMap.containsKey(s1Char) || s1Map.get(s1Char) != tempMap.get(s1Char)) {
                return false;
            }
        }
        return true;
    }
}
