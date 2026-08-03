//keeping a min heap of size k
//if min heap is not full, keep inserting elements
//otherwise, if current element is larger than min element, we pop and insert
//after iterating through the entire array, the min heap will
//have the k largest element of nums, the smallest among them is the kth largest element

class KthLargest {
    PriorityQueue<Integer> minHeap;
    int limit;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        limit = k;
        for(int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > limit) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        this.minHeap.add(val);
        if (minHeap.size() > limit) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
