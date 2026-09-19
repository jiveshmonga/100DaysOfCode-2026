#include <stdio.h>

int rob(int* nums, int numsSize)
{
    int prev2 = 0;
    int prev1 = 0;

    for (int i = 0; i < numsSize; i++)
    {
        int current = (prev1 > prev2 + nums[i])
                        ? prev1
                        : prev2 + nums[i];

        prev2 = prev1;
        prev1 = current;
    }

    return prev1;
}

int main()
{
    int nums[] = {2, 7, 9, 3, 1};

    int numsSize = sizeof(nums) / sizeof(nums[0]);

    int result = rob(nums, numsSize);

    printf("Maximum money: %d\n", result);

    return 0;
}