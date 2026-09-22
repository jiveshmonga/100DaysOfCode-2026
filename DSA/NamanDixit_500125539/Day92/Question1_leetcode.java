
class Question1_leetcode {
    // Function to find the number of ways
    // to reach the top of the staircase

    static int climbStairs(int n) {

        // If there is only 1 step,
        // there is only 1 way:
        // 1 step
        if (n == 1) {
            return 1;
        }

        // If there are 2 steps,
        // there are 2 ways:
        //
        // 1 + 1
        // 2
        if (n == 2) {
            return 2;
        }

        // This stores the number of ways
        // to reach the previous step
        int previous = 1;

        // This stores the number of ways
        // to reach the current step
        int current = 2;

        // Start calculating from step 3
        for (int i = 3; i <= n; i++) {

            // To reach the current step,
            // we can come from:
            //
            // 1. Previous step
            // 2. Two steps before
            //
            // So add both possibilities.
            int next = previous + current;

            // Move current to previous
            previous = current;

            // Move next to current
            current = next;
        }

        // Return the number of ways to reach
        // the top of the staircase
        return current;
    }

}
