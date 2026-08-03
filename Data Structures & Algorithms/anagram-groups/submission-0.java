class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //map of <String, List<String>> 
        //sort each string, if anagram, sorted string is the same

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            char[] mutable = s.toCharArray();
            Arrays.sort(mutable);
            String sorted = new String(mutable);

            map.computeIfAbsent(sorted, k -> new ArrayList<String>()).add(s);
        }

        return new ArrayList(map.values());
    }
}
