class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int w : stones) {
            maxHeap.offer(w);
        }

        while(maxHeap.size() > 1) {
            int s1 = maxHeap.poll();
            int s2 = maxHeap.poll();

            int remain = Math.abs(s1 - s2);
            if (remain != 0) {
                maxHeap.offer(remain);
            }
        }

        return maxHeap.size() == 1 ? maxHeap.peek() : 0;

    }
}
