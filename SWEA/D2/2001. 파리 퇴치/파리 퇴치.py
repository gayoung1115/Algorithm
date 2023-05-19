T = int(input())
for time in range(1, T + 1):
    N,M = map(int,input().split())
    space = [list(map(int,input().split())) for _ in range(N)]
    result =[]

    for i in range(N-M+1):
        for j in range(N-M+1):
            temp = 0
            for k in range(M):
                temp += sum(space[i+k][j:j+M])
            result.append(temp)

    print("#" + str(time)+" "+str(max(result)))