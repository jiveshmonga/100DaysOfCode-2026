# Coin Change

class Solution(object):
    def coinChange(self, coins, amount):
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0

        for coin in coins:
            for current in range(coin, amount + 1):
                dp[current] = min(dp[current], dp[current - coin] + 1)

        return dp[amount] if dp[amount] != amount + 1 else -1