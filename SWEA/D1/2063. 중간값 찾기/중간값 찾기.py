T=int(input())
arr = list(map(int, input().split()))

for i in range(len(arr)-1,0,-1):
    for j in range(i):
        if arr[j] > arr[j + 1]:
            temp = arr[j]
            arr[j] = arr[j + 1]
            arr[j + 1] = temp

print(arr[T//2])
