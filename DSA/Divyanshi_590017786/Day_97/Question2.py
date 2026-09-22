def max_energy(N, energy):
    if N == 1:
        return energy[0]

    dp = [0] * N

    dp[0] = energy[0]
    dp[1] = energy[0] + energy[1]

    for i in range(2, N):
        dp[i] = energy[i] + max(dp[i - 1], dp[i - 2])

    return dp[N - 1]


N = int(input())
energy = list(map(int, input().split()))

print(max_energy(N, energy))