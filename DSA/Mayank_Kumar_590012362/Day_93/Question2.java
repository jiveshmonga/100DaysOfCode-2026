class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] d = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            d[i][i] = 1;

            for (int j = i + 1; j < n; j++) {
                d[i][j] = d[i + 1][j] + 1;

                for (int k = i + 1; k <= j; k++) {
                    if (s.charAt(i) == s.charAt(k)) {
                        d[i][j] = Math.min(d[i][j],
                            d[i + 1][k - 1] + d[k][j]);
                    }
                }
            }
        }

        return d[0][n - 1];
    }
}