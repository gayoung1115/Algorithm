N = int(input())
arr = list(map(int,input().split()))
result = []

for i in range(N):
    if arr[i] == 0:
        result.append(i+1)
    else:
        result.insert(i-arr[i],i+1)
print(*result)