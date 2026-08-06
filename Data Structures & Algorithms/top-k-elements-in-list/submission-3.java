class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for(Integer key : freq.keySet()) {
            int count = freq.get(key);

            buckets.get(count - 1).add(key);
        } 

        List<Integer> out = new ArrayList<>();
        int bucketIndex = buckets.size() - 1;
        while (out.size() < k && bucketIndex >= 0) {
            List<Integer> bucket = buckets.get(bucketIndex);
            for(int i = 0; i < bucket.size(); i++) {
                out.add(bucket.get(i));
                if (out.size() == k) {
                    return toArray(out);
                }
            }
            bucketIndex -= 1;
        }
        return toArray(out);
    }

    public int[] toArray(List<Integer> out){
        int[] res = new int[out.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = out.get(i);
        }
        return res;
    }
}
