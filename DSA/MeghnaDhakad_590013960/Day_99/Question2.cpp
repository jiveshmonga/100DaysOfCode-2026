#include <iostream>
#include <vector>
#include <string>

using namespace std;

void dfs(vector<string>& grid, int r, int c) {
    int nr = grid.size();
    int nc = grid[0].size();
    
    // Boundary checks and water/visited check
    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
        return;
    }
    
    // Sink the current land cell so we don't visit it again
    grid[r][c] = '0';
    
    // Recursively sink all connected horizontal and vertical neighbors
    dfs(grid, r - 1, c); // up
    dfs(grid, r + 1, c); // down
    dfs(grid, r, c - 1); // left
    dfs(grid, r, c + 1); // right
}

int countLandmasses(vector<string>& grid) {
    if (grid.empty()) return 0;
    
    int count = 0;
    
    // Scan the entire grid
    for (int i = 0; i < grid.size(); ++i) {
        for (int j = 0; j < grid[0].size(); ++j) {
            // If we find an unvisited piece of land, we found a new landmass
            if (grid[i][j] == '1') {
                count++;
                // Sink the entire connected landmass
                dfs(grid, i, j);
            }
        }
    }
    
    return count;
}

int main() {
    // Example from the prompt
    vector<string> grid = {
        "11000",
        "11000",
        "00100",
        "00011"
    };
    
    cout << "Output: " << countLandmasses(grid) << "\n";
    // Expected Output: 3
    
    return 0;
}