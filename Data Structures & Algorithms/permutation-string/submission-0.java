class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        

        for(int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = left + s1.length() - 1;

        while(right < s2.length()) {
            String cur = s2.substring(left, right+1);
            if (isPermutation(map1, cur)) {
                return true;
            }

            left++;
            right++;
        }
        return false;
    }

    public boolean isPermutation(Map<Character, Integer> s1Map, String cur) {
        Map<Character, Integer> map2 = new HashMap<>();
        for(char c: cur.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0)+ 1);
        }

        for(char c: s1Map.keySet()) {
            if(!map2.containsKey(c) || s1Map.get(c) != map2.get(c)) {
                return false;
            }
        }

        return true;
    }
}
