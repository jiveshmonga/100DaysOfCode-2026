
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n= nums.length;
        int i=0;
        while(i<n){
            int correctInd= nums[i]-1;
            if(nums[i]>0 && nums[i]<=n && nums[i] != nums[correctInd]){
                swap(nums, i, correctInd);
            }
            else{
                i++;
            }
        }
        for(i=0; i<n; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }
    private void swap(int[] nums, int ind1, int ind2){
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2]= temp;
    }
}