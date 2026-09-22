class Solution {
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        else if(n==1 || n==2){
            return 1;
        }
       else{
         int term1=0;
         int term2=1;
         int term3=1;
         for(int i=1;i<=n;i++){
            int term4= term1+term2+term3;
            term1=term2;
            term2=term3;
            term3=term4;
         }
         return term1;
       }
    }
}