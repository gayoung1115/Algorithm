# 1946. 간단한 압축 풀기
T = int(input())
for time in range(1, T + 1):
    arr =[]
    N = int(input())
    for i in range(N):
        a, b = input().split()
        for j in range(int(b)):
            arr.append(a)
    print("#" + str(time))
    for j in range(0,len(arr),10):
        print(''.join(arr[0+j:10+j]))