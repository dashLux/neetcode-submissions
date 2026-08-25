class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int counter = 0;
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            map.computeIfAbsent(sorted, v -> new ArrayList<>()).add(s);
        }

        List<List<String>> out = new ArrayList<>();
        for(List<String> value : map.values()) {
            out.add(value);
        }

        return out;
    }
}
