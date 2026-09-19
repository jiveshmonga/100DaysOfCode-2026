//Given a string s consisting of lowercase English letters, determine the minimum number of turns required for a strange printer to
//print the entire string. In each turn, the printer can print the same character over any contiguous range and can overwrite 
//characters that have already been printed.
//Input: s = "abaabab". Output: 3.
#include <stdio.h>
#include <string.h>

int strangePrinter(char* s) {
    int n = strlen(s);
    if (n == 0)
        return 0;
    int dp[n][n];
    for (int i = 0; i < n; i++) {
        dp[i][i] = 1;
    }
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1;
            dp[i][j] = 1 + dp[i + 1][j];
            for (int k = i + 1; k <= j; k++) {
                if (s[i] == s[k]) {
                    int cost;
                    if (k == i + 1)
                        cost = dp[k][j];
                    else
                        cost = dp[i + 1][k - 1] + dp[k][j];
                    if (cost < dp[i][j])
                        dp[i][j] = cost;
                }
            }
        }
    }
    return dp[0][n - 1];
}

int main() {
    char s[101];
    printf("Enter string: ");
    scanf("%100s", s);
    printf("%d\n", strangePrinter(s));
    return 0;
}