class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 0;
        for (int p : piles) hi = Math.max(hi, p); // max possible speed needed

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (hoursNeeded(piles, mid) <= h) {
                hi = mid;       // mid works, try slower speed
            } else {
                lo = mid + 1;   // too slow, need faster speed
            }
        }
        return lo;
    }

    private long hoursNeeded(int[] piles, int k) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + k - 1) / k; // ceil(p / k)
        }
        return hours;
    }
}
