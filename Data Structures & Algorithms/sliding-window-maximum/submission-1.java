class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] out = new int[nums.length-k+1];
        Deque<Integer> dq = new LinkedList<>();
        int l = 0;
        int r = 0;

        //[1 2 1 0 4 2 6]

        while (r < nums.length) {
            //evict all elements smaller than e at current r
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[r]) {
                dq.removeLast();
            }
            dq.addLast(r);

            if (l > dq.getFirst()) {
                dq.removeFirst();
            }

            if (r + 1 >= k) {
                out[l] = nums[dq.getFirst()];
                l++;
            }
            r++;
        }
        return out;
    }
}
