//Given an array where each element represents the amount of money in a house, determine the maximum amount of money 
//that can be robbed without robbing two adjacent houses. The solution must use Dynamic Programming.
//Input: nums = [2, 7, 9, 3, 1]. Output: 12.
#include <stdio.h>

int rob(int* nums, int numsSize) {
    if (numsSize == 0)
        return 0;
    if (numsSize == 1)
        return nums[0];
    int prev2 = nums[0];
    int prev1 = (nums[0] > nums[1]) ? nums[0] : nums[1];
    for (int i = 2; i < numsSize; i++) {
        int robCurrent = nums[i] + prev2;
        int skipCurrent = prev1;
        int current = (robCurrent > skipCurrent) ? robCurrent : skipCurrent;
        prev2 = prev1;
        prev1 = current;
    }
    return prev1;
}

int main() {
    int n;
    printf("Enter number of houses: ");
    scanf("%d", &n);
    int nums[n];
    printf("Enter money in each house: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }
    printf("Maximum amount that can be robbed: %d\n", rob(nums, n));
    return 0;
}