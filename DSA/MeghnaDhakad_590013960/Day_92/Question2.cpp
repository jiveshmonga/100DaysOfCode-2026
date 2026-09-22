#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int rob(const vector<int>& nums) {
    int prev2 = 0; // Max money robbed up to the house before last
    int prev1 = 0; // Max money robbed up to the previous house
    
    for (int num : nums) {
        // Evaluate the choice: Rob this house + prev2, OR skip and keep prev1
        int current = max(prev1, prev2 + num);
        
        // Slide the window forward for the next iteration
        prev2 = prev1;
        prev1 = current;
    }
    
    return prev1;
}

int main() {
    vector<int> nums = {2, 7, 9, 3, 1};
    
    cout << "Output: " << rob(nums) << "\n";
    // Expected Output: 12 (Robbing houses with 2, 9, and 1)
    
    return 0;
}