class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] out = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[r]) {
                queue.removeLast();
            }
            queue.addLast(r);

            if (l > queue.getFirst()) {
                queue.removeFirst();
            }

            if (r + 1 >= k) {
                out[l] = nums[queue.getFirst()];
                l++;
            }
            r++;
        }
        return out;
    }
}
