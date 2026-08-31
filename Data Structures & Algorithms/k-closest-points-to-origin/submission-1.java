class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int d1 = getDistanceSq(a[0], a[1]);
            int d2 = getDistanceSq(b[0], b[1]);
            return d2 - d1;
        });

        for(int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] out = new int[k][2];
        int i = 0;
        for(int[] p : maxHeap) {
            out[i++] = p;
        }
        return out;



    }

    private int getDistanceSq(int x, int y) {
        return x*x + y*y;
    }
}
