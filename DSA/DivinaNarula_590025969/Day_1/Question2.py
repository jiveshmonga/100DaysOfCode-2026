def array_sum(arr):
    count = 0

    for num in arr:
        count += num

    return count


input_values = input("Enter numbers separated by spaces: ").split()

arr = []
for value in input_values:
    arr.append(int(value))

result = array_sum(arr)
print("Sum =", result)