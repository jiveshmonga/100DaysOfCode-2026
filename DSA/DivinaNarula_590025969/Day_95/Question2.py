# The Festival Schedule

T = int(input("Enter available time: "))
n = int(input("Enter number of activities: "))

duration = list(map(int, input("Enter activity durations: ").split()))
happiness = list(map(int, input("Enter happiness points: ").split()))

dp = [0] * (T + 1)

for i in range(n):
    for time in range(T, duration[i] - 1, -1):
        dp[time] = max(dp[time], dp[time - duration[i]] + happiness[i])

print("Maximum happiness:", dp[T])