
// Solution class
class Question1_leetcode {

    public int minEatingSpeed(int[] piles, int h) {

        // Find the largest pile
        int maxPile = 0;

        for (int i = 0; i < piles.length; i++) {

            if (piles[i] > maxPile) {
                maxPile = piles[i];
            }
        }

        // Minimum possible speed
        int left = 1;

        // Maximum possible speed
        int right = maxPile;

        // Store the answer
        int answer = maxPile;

        // Binary Search
        while (left <= right) {

            // Find middle speed
            int mid = left + (right - left) / 2;

            // Total hours required
            long hours = 0;

            // Check every pile
            for (int i = 0; i < piles.length; i++) {

                // Calculate hours needed for this pile
                // This is ceiling(pile / speed)
                hours += (piles[i] + mid - 1) / mid;
            }

            // If Koko can finish within h hours
            if (hours <= h) {

                // This speed works
                answer = mid;

                // Try a smaller speed
                right = mid - 1;

            } else {

                // Speed is too slow
                // Try a bigger speed
                left = mid + 1;
            }
        }

        // Return minimum speed
        return answer;
    }
}
