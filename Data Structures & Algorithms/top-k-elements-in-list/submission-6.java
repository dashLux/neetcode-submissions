/**

    1. record frequencies of elements, then sort by frequency and take the first k
    time complexity O(nlgn) for sorting, space: O(n) for hashmap

    2. record frequency of elements, then put them into "buckets". Buckets are in a list
       index of the bucket represents the element frequency. e.g. 2 in bucket 0 meaning 
       element 2 has frequency 1, 3 in bucket 1 meaning element 3 has frequency 2, etc.

       when outputing, we start from the bucket with highest index, keep adding elements 
       from bucket until we reach k.

       time: O(n) for frequency scan and putting k element in output (k <= n).
       space: O(n) for bucket list (total size of bucket list is n)
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> buckets = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            buckets.add(new ArrayList<>());
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : freq.keySet()) {
            buckets.get(freq.get(key) - 1).add(key);
        }
        

        // for(int i = 0 ; i < buckets.size(); i++) {
        //     System.out.println(String.format("\nBucket %d", i));
        //     for(int j = 0; j < buckets.get(i).size(); j++) {
        //         System.out.print(buckets.get(i).get(j));
        //         System.out.print(" ");
        //     }
        // }


        int[] out = new int[k];
        int j = 0;
        int bucketIndex = buckets.size() - 1;
        while (j < k && bucketIndex >= 0) {
            List<Integer> bucket = buckets.get(bucketIndex);
            for(int n : bucket) {
                out[j] = n;
                j++;
                if (j == k) {
                    return out;
                }
            }
            bucketIndex--;
        }
        return out;
    }
}
