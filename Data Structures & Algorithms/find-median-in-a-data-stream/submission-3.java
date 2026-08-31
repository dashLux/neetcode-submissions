class MedianFinder {
    PriorityQueue<Integer> maxHeap; //hold lower half of the stream
    PriorityQueue<Integer> minHeap; //hold upper half of the stream

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a, b) -> b -a);
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if (maxHeap.size() - minHeap.size() > 1
           || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
           }
        
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return ((double)minHeap.peek() + maxHeap.peek())/2;
        }
        if (minHeap.size() > maxHeap.size()) {
            return (double)minHeap.peek();
        }
        else {
            return (double)maxHeap.peek();
        }
        
    }
}
