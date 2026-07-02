def Asum(A):
    s = 0
    for i in range(len(A)):
        s += A[i]
    return s

A = [10,20,30,50,60]
print(Asum(A))
