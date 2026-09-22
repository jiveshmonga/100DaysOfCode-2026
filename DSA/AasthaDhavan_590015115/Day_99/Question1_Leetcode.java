class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<n){
            int ci=nums[i]-1; //correctidx
            if(nums[i]>0 && nums[i]<=n && nums[i]!=nums[ci]){
                swap(nums,i,ci);
            } else{
                i++;
            }

        }
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        return n+1;
    }

    private void swap(int []a,int i1,int i2){
        int temp=a[i1];
        a[i1]=a[i2];
        a[i2]=temp;
    }
}