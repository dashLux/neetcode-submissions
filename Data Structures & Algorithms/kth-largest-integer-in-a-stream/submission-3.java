class KthLargest {
    PriorityQueue<Integer> minHeap;
    int capacity;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.capacity = k;

        for(int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > capacity) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
