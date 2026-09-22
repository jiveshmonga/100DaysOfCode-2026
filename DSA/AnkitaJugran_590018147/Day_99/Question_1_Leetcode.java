class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;

        // Place each number at its correct index
        while (i < n) {
            int correctIndex = nums[i] - 1;

            if (nums[i] > 0 && nums[i] <= n
                    && nums[i] != nums[correctIndex]) {

                // Swap
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;

            } else {
                i++;
            }
        }

        // Find the first missing positive
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // All numbers from 1 to n are present
        return n + 1;
    }
}