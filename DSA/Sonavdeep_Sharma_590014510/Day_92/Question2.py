nums = [2, 7, 9, 3, 1]
a = 0
b = 0

for money in nums:
    a, b = b, max(b, a + money)
print(b)