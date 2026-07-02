//c code to find sum of elements in an array 
#include<stdio.h>
int main()
{
    int n ,sum;
    sum=0;
    printf("enter size");
    scanf("%d",&n);
    int arr[n];
    printf("enter elements");
    for(int i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
    for(int i=0;i<n;i++)
    {
        sum=sum+arr[i];
    }
    printf("sum of elements is %d",sum);
    return 0;

}