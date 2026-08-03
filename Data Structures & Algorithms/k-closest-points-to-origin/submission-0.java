class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                int d1 = getDistanceSq(p1[0], p1[1]);
                int d2 = getDistanceSq(p2[0], p2[1]);
                return d2 - d1;
            }
        });

        for(int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] out = new int[k][2];
        int i = 0;
        while(maxHeap.size() > 0) {
            out[i++] = maxHeap.poll();
        }
        return out;

    }

    public int getDistanceSq(int x, int y) {
        return x*x + y*y;
    }
}
