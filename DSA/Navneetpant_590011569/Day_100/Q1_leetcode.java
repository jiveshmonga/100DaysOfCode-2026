class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = piles[0];

        for (int pile : piles) {
            if (pile > right) {
                right = pile;
            }
        }

        while (left < right) {
            int mid = left + (right - left)/2;
            if (canFinish (piles , h , mid )) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;

    }
    public boolean canFinish (int [] piles , int h , int mid) {
        long hour = 0 ; 
        for (int pile : piles) {
            hour += (pile + mid - 1) / mid;
        }
        return hour <=h;
    }


}