
// problem that introduces array traversal techniques and teaches how to efficiently process every
// element while maintaining a running total of values present in an array.
// Given an array of integers, the task is to find the sum of all elements in the array.
// This problem appears frequently in interviews and real-world applications like analytics process-ing,
// financial calculations, reporting systems, and data aggregation tasks. The challenge involves
// traversing the array efficiently and accumulating the result.
// This teaches:
// • array traversal
// • accumulation logic
// • variable tracking
// • optimization techniques
// which are essential for efficient data processing and interview problem solving.

#include<iostream>
#include<vector>

using namespace std;

int main(){
    int arr[20];
    int n;
    cout<<"Enter size: ";
    cin>>n;

    for(int i = 0 ; i < n ; i++){
        cin>>arr[i];
    }
    
    int total = 0;
    for(int i = 0 ; i < n ; i++){
        total += arr[i];
    }
    cout<<total<<endl;
}
