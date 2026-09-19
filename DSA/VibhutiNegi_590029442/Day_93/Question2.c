#include <stdio.h>
#include <string.h>
int strangePrinter(char s[]) {
    int n = strlen(s);
    int dp[100][100];
    for (int i = 0; i < n; i++) {
        dp[i][i] = 1;
    }
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1;
            dp[i][j] = dp[i][j - 1] + 1;
            for (int k = i; k < j; k++) {
                if (s[k] == s[j]) {
                    int left = (k > i) ? dp[i][k - 1] : 0;
                    int right = dp[k][j - 1];
                    int turns = left + right;
                    if (turns < dp[i][j]) {
                        dp[i][j] = turns;
                    }
                }
            }
        }
    }
    return dp[0][n - 1];
}
int main() {
    int n;
    char s[101];
    scanf("%d", &n);
    scanf("%s", s);
    printf("%d", strangePrinter(s));
    return 0;
}