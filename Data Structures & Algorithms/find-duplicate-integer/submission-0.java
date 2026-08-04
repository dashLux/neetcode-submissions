class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0)+1);
        }

        for(int k : freq.keySet()) {
            if (freq.get(k) > 1){
                return k;
            }
        }
        return -1;
    }
}
