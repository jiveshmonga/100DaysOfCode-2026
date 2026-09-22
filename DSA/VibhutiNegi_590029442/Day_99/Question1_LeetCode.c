int firstMissingPositive(int* nums, int numsSize) {
    int i = 0;
    while (i < numsSize) {
        int x = nums[i];
        if (x >= 1 && x <= numsSize && nums[x - 1] != x) {
            int temp = nums[i];
            nums[i] = nums[x - 1];
            nums[x - 1] = temp;
        } else {
            i++;
        }
    }
    for (i = 0; i < numsSize; i++) {
        if (nums[i] != i + 1) {
            return i + 1;
        }
    }
    return numsSize + 1;  
}