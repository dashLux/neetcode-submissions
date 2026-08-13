/**
    realizing the small k to be picked is 1, and the largest k to be pick will be
    max(piles[i]) for i = 0 to piles.length-1

    because if we pick bigger k, it won't help with hours
    so we can do binary search in range of [1, max(piles[i])] for k, if a k is picked and hour > h, we 
    return the closest k
*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int i = 0; i < piles.length; i++) {
            maxPile = Math.max(piles[i], maxPile);
        }

        int left = 1;
        int right = maxPile;

        int res = right;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinishEating(mid, piles, h)) {
                res = mid;
                right = mid - 1;
            }
            else {
                left = mid +1;
            }
        }
        return res;
    }

    private boolean canFinishEating(int k, int[] piles, int h) {
        int totalHour = 0;
        for(int p : piles) {
            if (p % k == 0) {
                totalHour += p / k;
            }
            else {
                totalHour += p / k + 1;
            }
        }
        return totalHour <= h;
    }
}
