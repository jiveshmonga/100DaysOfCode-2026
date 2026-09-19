
class Question1_leetcode {

    public int[] countBits(int n) {

        // Create an array to store the answer
        // ans[i] = number of 1s in binary representation of i
        int[] ans = new int[n + 1];

        // Start from 1
        // ans[0] is already 0 because binary 0 has no 1s
        for (int i = 1; i <= n; i++) {

            // i / 2 removes the last binary digit
            //
            // Example:
            // 5 = 101
            // 5 / 2 = 2 = 10
            //
            // ans[i / 2] gives the number of 1s
            // in the remaining binary digits
            // i % 2 checks the last binary digit
            //
            // If i is even → last bit is 0
            // If i is odd  → last bit is 1
            //
            // So:
            // ans[i] = ans[i / 2] + last bit
            ans[i] = ans[i / 2] + (i % 2);
        }

        // Return the complete answer array
        return ans;
    }
}
