class Solution {
    public int strangePrinter(String s) {
        // Remove consecutive duplicate characters
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
            }
        }
        String t = sb.toString();
        int n = t.length();
        if (n == 0) return 0;

        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + 1; // worst case: print char at j separately
                for (int k = i; k < j; k++) {
                    if (t.charAt(k) == t.charAt(j)) {
                        int right = (k + 1 <= j - 1) ? dp[k + 1][j - 1] : 0;
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + right);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
