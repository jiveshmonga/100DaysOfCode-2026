n=int(input())
l=[]

for i in range(n):
    x=int(input())
    l.append(x)

ans=[0]*n
stack=[]

for i in range(n):
    while stack and l[i]>l[stack[-1]]:
        j=stack.pop()
        ans[j]=i-j
    stack.append(i)

print(*ans)
