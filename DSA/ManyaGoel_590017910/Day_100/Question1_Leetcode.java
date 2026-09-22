class Question1_Leetcode {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;
        long total = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
            total += pile;
        }

        long extraHours = h - n;
        long low = Math.max(1L,Math.max((total + h - 1L) / h,(max + extraHours) / (extraHours + 1)));
        long high = max;
        if (extraHours > 0) {
            high = Math.min(high,(total + extraHours - 1) / extraHours );
        }
        while (low < high) {
            int speed = (int) (low + (high - low) / 2);
            long hours = 0;
            for (int pile : piles) {
                hours += (pile + (long) speed - 1) / speed;
                if (hours > h) {
                    low = speed + 1;
                    break;
                }
            }
            if (hours <= h) {
                high = speed;
            }
        }
        return (int) low;
    }
}