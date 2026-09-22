
class Question1_leetcode {

    public static int firstMissingPositive(int[] nums) {

        // Get the size of the array
        int n = nums.length;

        // Create a boolean array
        //
        // seen[i] = true means
        // number i exists in the original array
        //
        // We create n + 1 because we want
        // to check numbers from 1 to n.
        boolean[] seen = new boolean[n + 1];

        // Go through every number in nums
        for (int i = 0; i < n; i++) {

            // Store the current number
            int num = nums[i];

            // We only care about positive numbers
            // between 1 and n.
            //
            // Ignore:
            // 0
            // negative numbers
            // numbers greater than n
            if (num >= 1 && num <= n) {

                // Mark this number as present
                seen[num] = true;
            }
        }

        // Now check numbers starting from 1
        for (int i = 1; i <= n; i++) {

            // If this number was not found
            // then it is the first missing positive
            if (seen[i] == false) {

                return i;
            }
        }

        // If all numbers from 1 to n exist,
        // then the answer must be n + 1.
        return n + 1;
    }

}
