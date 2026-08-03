class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : stones) {
            maxHeap.add(w);
        }

        while(maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            int delta = Math.abs(x - y);
            maxHeap.add(delta);
        }

        return maxHeap.peek();
    }
}
