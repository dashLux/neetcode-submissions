/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for(int i = 0; i < intervals.size(); i++) {
            if (!minHeap.isEmpty() && intervals.get(i).start >= minHeap.peek()) {
                minHeap.poll();
            }
           minHeap.offer(intervals.get(i).end);
        }

        return minHeap.size();
    }
}
