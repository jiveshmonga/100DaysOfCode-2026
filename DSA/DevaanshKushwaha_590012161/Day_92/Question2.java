class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // prev2 = best amount robbable using houses [0..i-2]
        // prev1 = best amount robbable using houses [0..i-1]
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]); // skip i vs rob i
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
