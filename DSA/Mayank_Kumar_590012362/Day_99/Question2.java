class Solution {
    public int numIslands(char[][] g) {
        int r = g.length, c = g[0].length, ans = 0;

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (g[i][j] == '1') {
                    ans++;
                    dfs(g, i, j);
                }

        return ans;
    }

    void dfs(char[][] g, int i, int j) {
        if (i < 0 || j < 0 || i == g.length || j == g[0].length || g[i][j] != '1')
            return;

        g[i][j] = '0';

        dfs(g, i + 1, j);
        dfs(g, i - 1, j);
        dfs(g, i, j + 1);
        dfs(g, i, j - 1);
    }
}