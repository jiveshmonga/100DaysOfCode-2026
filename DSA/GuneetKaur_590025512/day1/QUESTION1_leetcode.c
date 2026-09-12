//missing number 
#include<stdio.h>
int missing( int* nums , int numsize )
{
    int sum=0;
    for(int i=0;i<numsize;i++)
    {
        sum=sum+nums[i];
    }
    int sum1=(numsize*(numsize+1))/2;
    return sum1-sum;
}
int main()
{
    int n;
    printf("enter size");
    scanf("%d",&n);
    int arr[n];
    printf("enter elements");
    for(int i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
    int result=missing(arr,n);
    printf("missing number is %d",result);
    return 0;
}