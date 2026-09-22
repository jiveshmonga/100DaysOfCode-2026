int tribonacci(int n) {
   int a=0,b=1,c=1,next;
   if(n==0) return 0;
   if(n==1||n==2) return 1;

   for(int i=3;i<=n;i++) {
     next=a+b+c;
     a=b;
     b=c;
     c=next;  } 
   return next;
}
