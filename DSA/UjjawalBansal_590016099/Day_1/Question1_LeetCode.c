int missingNumber(int* nums, int numsSize) {
    int a = numsSize;
    for (int i=0; i<numsSize; i++) {
        a ^= i^nums[i];
    }
    return a;
}