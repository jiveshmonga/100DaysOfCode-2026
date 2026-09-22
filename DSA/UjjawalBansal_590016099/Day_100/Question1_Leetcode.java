class Question1_Leetcode {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;
        long sum = 0;

        for (int p : piles) {
            max = Math.max(max, p);
            sum += p;
        }

        long extra = h - n;
        long low = Math.max(1L,Math.max((sum + h - 1L) / h,(max + extra) / (extra + 1)));
        long high = max;
        if (extra > 0) {
            high = Math.min(high,(sum + extra - 1) / extra);
        }

        while (low < high) {
            int mid = (int) (low + (high - low) / 2);
            long hours = 0;
            for (int p : piles) {
                hours += (p + (long) mid - 1) / mid;

                if (hours > h) {
                    low = mid + 1;
                    break;
                }
            }
            if (hours <= h) {
                high = mid;
            }
        }
        return (int) low;
    }
}