#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int left = 1;
        int right = 0;
        
        // Find the maximum pile size to set our upper bound
        for (int pile : piles) {
            right = max(right, pile);
        }
        
        int best_speed = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long long hours = 0; // Use long long to prevent overflow on large piles
            
            // Calculate total hours required at 'mid' speed
            for (int pile : piles) {
                // Equivalent to ceil((double)pile / mid) but keeps it in integer math
                hours += (pile + mid - 1) / mid; 
            }
            
            if (hours <= h) {
                best_speed = mid;   // This speed is valid, save it
                right = mid - 1;    // Try to find a slower valid speed
            } else {
                left = mid + 1;     // Too slow, we must eat faster
            }
        }
        
        return best_speed;
    }
};