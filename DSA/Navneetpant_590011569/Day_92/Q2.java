class Solution {
    public int rob(int[] nums) {
        int prevPrev = 0;
        int prev = 0;

        for (int i = 0 ; i < nums.length ; i++ ) {
            int current = Math.max (prev, prevPrev + nums[i]);
            prevPrev = prev;
            prev = current;
        }
        return prev;
    }
}