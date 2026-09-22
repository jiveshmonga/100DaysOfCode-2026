class Solution {
    public int countLandmasses(String[] grid) {
        // Empty grid has no land
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length();
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Unvisited land cell = start of a brand-new landmass
                if (grid[r].charAt(c) == '1' && !visited[r][c]) {
                    count++;
                    dfs(grid, visited, r, c);   // mark the entire landmass
                }
            }
        }
        return count;
    }

    private void dfs(String[] grid, boolean[][] visited, int r, int c) {
        // Stop if out of bounds, water, or already visited
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length()
                || grid[r].charAt(c) != '1' || visited[r][c]) {
            return;
        }

        visited[r][c] = true;   // mark before recursing to avoid revisiting

        // Explore the 4 directions (no diagonals)
        dfs(grid, visited, r + 1, c);
        dfs(grid, visited, r - 1, c);
        dfs(grid, visited, r, c + 1);
        dfs(grid, visited, r, c - 1);
    }
}
