# Days Until a Warmer Temperature

temperatures = list(map(int, input("Enter temperatures separated by spaces: ").split()))

n = len(temperatures)
answer = [0] * n
stack = []

for i in range(n):
    while stack and temperatures[i] > temperatures[stack[-1]]:
        previous_day = stack.pop()
        answer[previous_day] = i - previous_day

    stack.append(i)

print("Days until warmer temperature:")
print(*answer)