/**
    binary search approach

    + find the maximum bananas among piles m
    + create search space k = [1...m]
    + binary search in our search space
        + for each k = mid, test if we can finish all bananas in h
        + if yes, then shrink search space to the left half (try finding a smaller k)
        + if no, then shrink search space to the right half (try finding a larger k)
*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        int ans = -1;
        for(int p : piles) {
            max = Math.max(max, p);
        }

        //binary search in k = [1...max]
        int left = 1;
        int right = max;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (canFinishEating(mid, piles, h)) {
                // look for smaller k
                ans = mid;
                right = mid - 1;

            }
            else {
                // look for larger k
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean canFinishEating(int k, int[] piles, int h) {
        int totalHours = 0;
        for(int p : piles) {
            if (p % k == 0) {
                totalHours += p/k;
            }
            else {
                totalHours += (p/k)+1;
            }
        }
        return totalHours <= h;
    }
}
