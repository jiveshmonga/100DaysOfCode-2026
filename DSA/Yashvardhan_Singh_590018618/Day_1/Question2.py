def find_sum(arr):
    sum = 0
    for num in arr:
        sum += num
    return sum

arr = [10, 54, 5, 39, 44, 2]
print(find_sum(arr))