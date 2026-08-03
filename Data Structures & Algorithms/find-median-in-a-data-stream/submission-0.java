class MedianFinder {
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>(Collections.reverseOrder());
        largeHeap = new PriorityQueue<>();    
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        if (smallHeap.size() - largeHeap.size() > 1 ||
            !largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()) {
                largeHeap.add(smallHeap.poll());
            }
        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if (smallHeap.size() == largeHeap.size()) {
            return (double)(largeHeap.peek() + smallHeap.peek()) / 2;
        }
        if (smallHeap.size() > largeHeap.size()) {
            return (double) smallHeap.peek();
        }
        return (double)largeHeap.peek();
    }
}
