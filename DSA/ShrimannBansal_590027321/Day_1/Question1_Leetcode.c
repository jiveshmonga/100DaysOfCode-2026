int missingNumber(int* nums, int numsSize) 
{
    int ExSum=numsSize*(numsSize+1)/2;
    int actl = 0;
    for (int i=0; i<numsSize;i++)
    {
        actl+=nums[i];
    }
    return ExSum-actl;
}
