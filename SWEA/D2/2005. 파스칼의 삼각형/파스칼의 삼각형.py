# 파스칼의 삼각형
T = int(input())
for time in range(1, T+1):
    print("#"+str(time))
    result =[]
    N = int(input())
    for i in range(N):
        temp = []
        for j in range(i+1):
            if j ==0 or j ==i:
                temp.append(1)
            else:
                temp.append(result[i-1][j]+result[i-1][j-1])
        result.append(temp)

    for i in result:
        print(*i)