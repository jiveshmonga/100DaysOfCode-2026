n = 7
cuts = [1, 3, 4, 5]

cuts = [0] + sorted(cuts) + [n]
m = len(cuts)

dp = [[0] * m for _ in range(m)]

for length in range(2, m):
    for i in range(m - length):
        j = i + length
        dp[i][j] = float('inf')

        for k in range(i + 1, j):
            cost = (cuts[j] - cuts[i]) + dp[i][k] + dp[k][j]
            dp[i][j] = min(dp[i][j], cost)

print(dp[0][m - 1])