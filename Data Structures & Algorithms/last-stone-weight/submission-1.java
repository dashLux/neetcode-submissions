/**

max heap solution
- time: O(nlogn) --> each heap insert is O(logn), total of n inserts
- space: O(n) -> heap of size n worst case

*/

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
