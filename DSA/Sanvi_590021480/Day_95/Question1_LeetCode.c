int tribonacci(int n) {
   int first=0,second=1,third=1,next;
   if(n==0) return 0;
   if(n==1||n==2) return 1;

   for(int i=3;i<=n;i++) {
     next=first+second+third;
     first=second;
     second=third;
     third=next;
   } 
   return next;
}
