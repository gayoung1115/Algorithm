T = int(input())
for time in range(1, T + 1):
    result = 0
    N = int(input())
    a = list(map(int, input().split()))
    a.sort()
    a = [str(i) for i in a]
    print("#" + str(time)+" "+' '.join(a))