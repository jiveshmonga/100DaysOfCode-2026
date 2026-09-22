class Solution {
    private int calc(int [] a,int speed){
        int total=0;
        for(int b: a){
            total+=Math.ceil((double)b/speed);
        }
        return total;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxpile=Arrays.stream(piles).max().getAsInt();
        int l=0;
        int hi=maxpile;
        int ans=maxpile;
        while(l<=hi){
            int mid=l+(hi-l)/2;
            int totalhrs=calc(piles,mid);
            if(totalhrs<=h){
                ans=mid;
                hi=mid-1;
            } else{
                l=mid+1;
            }

        }
        return ans;
    }

}