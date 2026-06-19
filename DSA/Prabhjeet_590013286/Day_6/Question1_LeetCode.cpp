#include <vector>
class Solution {
public:

    int robLinear(vector<int>& nums, int start, int end) {

        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {

            int curr = max(prev1, prev2 + nums[i]); // this Chooses rob or skip

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    int rob(vector<int>& nums) {

        int n = nums.size();

        if (n == 1) { // Only one house
            return nums[0];
        }

        return max(
            robLinear(nums, 0, n - 2), //this Excludes last house
            robLinear(nums, 1, n - 1)  // this Excludes first house
        );
    }
};