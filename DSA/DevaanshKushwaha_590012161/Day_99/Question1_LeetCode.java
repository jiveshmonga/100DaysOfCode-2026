class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Phase 1: place each value x (1 <= x <= n) at index x - 1
        for (int i = 0; i < n; i++) {
            // Keep swapping until nums[i] is out of range or already in its correct slot
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctIdx = nums[i] - 1;
                int temp = nums[correctIdx];
                nums[correctIdx] = nums[i];
                nums[i] = temp;
            }
        }

        // Phase 2: first index where the value is wrong gives the answer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // All of 1..n are present
        return n + 1;
    }
}
