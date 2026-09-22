#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int maxEnergyTower(int n, const vector<int>& energy) {
    if (n == 0) return 0;
    if (n == 1) return energy[0];
    
    int prev2 = 0;         // Max energy up to two floors down
    int prev1 = energy[0]; // Max energy up to the previous floor (starting at floor 1)
    
    // Iterate from the second floor up to N
    for (int i = 1; i < n; ++i) {
        // We can reach the current floor from either i-1 or i-2
        int current = energy[i] + max(prev1, prev2);
        
        // Slide the window forward
        prev2 = prev1;
        prev1 = current;
    }
    
    return prev1;
}

int main() {
    int n = 6;
    vector<int> energy = {5, 10, 20, 15, 25, 30};
    
    cout << "Output: " << maxEnergyTower(n, energy) << "\n";
    // Expected Output: 105
    
    return 0;
}