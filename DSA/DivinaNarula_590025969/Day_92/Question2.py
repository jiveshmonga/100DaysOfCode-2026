# House Robber

def houseRobber(nums):
    previous = 0
    current = 0

    for money in nums:
        new_current = max(current, previous + money)
        previous = current
        current = new_current

    return current


n = int(input("Enter number of houses: "))
nums = list(map(int, input("Enter money in each house: ").split()))

result = houseRobber(nums)

print("Maximum money that can be robbed:", result)