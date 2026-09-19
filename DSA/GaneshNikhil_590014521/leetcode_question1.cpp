class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int size = nums.size();
        int iter_total = 0;
        for(int i = 0 ; i < size ; i++){
            iter_total += nums[i];
        }

        int total = (size * (size + 1))/2;
        if(iter_total != total){
            return total - iter_total;
        }
        return 0;
    }
};