arr = [int(input()) for _ in range(9)]
arr.sort()

for i in range(8):
    for j in range(i+1, 9):
        sum_ar = sum(arr) - arr[i] - arr[j]
        if sum_ar == 100:
            temp,temp2 = arr[i],arr[j]
            arr.remove(temp)
            arr.remove(temp2)
            break
    if sum(arr) == 100:
        break
arr.sort()
for a in arr:
    print(a)