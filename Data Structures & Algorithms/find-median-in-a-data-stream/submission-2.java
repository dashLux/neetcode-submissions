class MedianFinder {
    //storing lower half numbers
    PriorityQueue<Integer> maxHeap;
    //storing upper half numbers
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        maxHeap.add(num);

        //balance if size diff is greater than 1 or max heap top is greater 
        //than min heap top
        if (maxHeap.size() - minHeap.size() > 1
            || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()
        ) {
            minHeap.add(maxHeap.poll());
        }

        //if size diff still greater than 1, we rebalance
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }

        if (minHeap.size() > maxHeap.size()) {
            return (double)minHeap.peek();
        }
        return (double)maxHeap.peek();
        
    }
}
