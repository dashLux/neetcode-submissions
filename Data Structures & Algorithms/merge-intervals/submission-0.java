class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> out = new ArrayList<>();
        out.add(new int[]{intervals[0][0], intervals[0][1]});

        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] last = out.get(out.size() - 1);

            if(interval[0] <= last[1]) {
                last[1] = Math.max(interval[1], last[1]);
            }
            else {
                out.add(interval);
            }
        }
        return out.toArray(new int[0][0]);
    }
}
