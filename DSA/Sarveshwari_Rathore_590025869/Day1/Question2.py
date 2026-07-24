n = int(input("Enter the number of elements: "))
arr = []

b = input("Enter elements: ").split()
for a in b:
    arr.append(int(a))

print("Sum of array elements:", sum(arr))