def max_happiness(T, duration, happiness):
    n = len(duration)

    dp = [0] * (T + 1)

    for i in range(n):
        for t in range(T, duration[i] - 1, -1):
            dp[t] = max(
                dp[t],
                dp[t - duration[i]] + happiness[i]
            )

    return dp[T]


T = int(input())
duration = list(map(int, input().split()))
happiness = list(map(int, input().split()))

print(max_happiness(T, duration, happiness))