#include <iostream>
#include <vector>
#include <stack>

using namespace std;

vector<int> dailyTemperatures(const vector<int>& temperatures) {
    int n = temperatures.size();
    vector<int> result(n, 0); // Default to 0 days if no warmer temp is found
    stack<int> s; // Stack will store INDICES, not temperatures
    
    for (int i = 0; i < n; ++i) {
        // While current temp is warmer than the temp at the index on top of the stack
        while (!s.empty() && temperatures[i] > temperatures[s.top()]) {
            int prev_day_index = s.top();
            s.pop();
            // The number of days is the difference between indices
            result[prev_day_index] = i - prev_day_index; 
        }
        // Push the current day's index onto the stack to wait for a warmer day
        s.push(i);
    }
    
    return result;
}

int main() {
    vector<int> temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
    
    vector<int> result = dailyTemperatures(temperatures);
    
    cout << "Output: ";
    for (int days : result) {
        cout << days << " ";
    }
    cout << "\n";
    // Expected Output: 1 1 4 2 1 1 0 0[cite: 20]
    
    return 0;
}