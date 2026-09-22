# The Energy Tower

n = int(input("Enter number of floors: "))
energy = list(map(int, input("Enter energy values: ").split()))

if n == 1:
    print(energy[0])
else:
    prev2 = energy[0]
    prev1 = energy[0] + energy[1]

    for i in range(2, n):
        current = energy[i] + max(prev1, prev2)
        prev2 = prev1
        prev1 = current

    print(prev1)