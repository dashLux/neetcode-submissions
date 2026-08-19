class Solution {
    public int[][] merge(int[][] intervals) {
        //sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> out = new ArrayList<>();

        int i = 1;
        int[] interval = intervals[0];
        while (i < intervals.length) {
            int[] next = intervals[i];
            if (next[0] <= interval[1]) {
                interval[1] = Math.max(next[1], interval[1]);
            }
            else {
                out.add(interval);
                interval = next;
            }
            i++;
        }
        out.add(interval);

        int[][] res = new int[out.size()][2];
        for(int j = 0; j < res.length; j++) {
            res[j] = out.get(j);
        }

        return res;
        
    }
}
