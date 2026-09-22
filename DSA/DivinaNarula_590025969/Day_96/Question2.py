# The Signal Relay

T = int(input("Enter total available time: "))
n = int(input("Enter number of activities: "))

duration = list(map(int, input("Enter activity durations: ").split()))
happiness = list(map(int, input("Enter happiness points: ").split()))

dp = [0] * (T + 1)

for i in range(n):
    for time in range(T, duration[i] - 1, -1):
        dp[time] = max(dp[time], happiness[i] + dp[time - duration[i]])

print("Maximum happiness:", dp[T])