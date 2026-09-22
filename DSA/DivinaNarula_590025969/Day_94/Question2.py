# Minimum Cost to Cut a Stick

def minCost(n, cuts):
    cuts = [0] + sorted(cuts) + [n]
    m = len(cuts)

    dp = [[0] * m for _ in range(m)]

    for length in range(2, m):
        for left in range(m - length):
            right = left + length
            dp[left][right] = float('inf')

            for mid in range(left + 1, right):
                cost = cuts[right] - cuts[left] + dp[left][mid] + dp[mid][right]
                dp[left][right] = min(dp[left][right], cost)

    return dp[0][m - 1]


n = int(input("Enter the length of the stick: "))
cuts = list(map(int, input("Enter the cut positions separated by spaces: ").split()))

print("Minimum cost:", minCost(n, cuts))