# Strange Printer

def strangePrinter(s):
    n = len(s)

    if n == 0:
        return 0

    dp = [[0] * n for _ in range(n)]

    for i in range(n - 1, -1, -1):
        dp[i][i] = 1

        for j in range(i + 1, n):
            dp[i][j] = dp[i + 1][j] + 1

            for k in range(i + 1, j + 1):
                if s[i] == s[k]:
                    cost = dp[k][j]

                    if k > i + 1:
                        cost += dp[i + 1][k - 1]

                    dp[i][j] = min(dp[i][j], cost)

    return dp[0][n - 1]


s = input("Enter the string: ")
print("Minimum number of turns:", strangePrinter(s))