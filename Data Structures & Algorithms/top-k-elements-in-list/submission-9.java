class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for(int key : counter.keySet()) {
            buckets.get(counter.get(key) - 1).add(key);
        }

        int[] out = new int[k];
        int bucketIndex = buckets.size() - 1;
        int filled = 0;
        while (filled < k && bucketIndex >= 0) {
            List<Integer> bucket = buckets.get(bucketIndex);
            for(int n : bucket) {
                out[filled] = n;
                filled++;
                if (filled == k) {
                    return out;
                }
            }
            bucketIndex--;
        }
        return out;
    }
}
