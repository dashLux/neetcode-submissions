class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        maxHeap.add(num);
        if (maxHeap.size() - minHeap.size() > 1 || (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())) {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return ((double)maxHeap.peek() + minHeap.peek()) * 0.5;
        }

        if (maxHeap.size() > minHeap.size()) {
            return (double)maxHeap.peek();
        }

        return (double)minHeap.peek();
        
    }
}
