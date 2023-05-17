#1979. 어디에 단어가 들어갈 수 있을까
T = int(input())

for time in range(1, T + 1):
    N,K = map(int, input().split())
    space = [list(map(int,input().split())) for _ in range(N)]
    result = 0

    for i in range(N):
        count = 0
        for j in range(N):
            if space[i][j] == 1 :
                count +=1
                if j == N-1 and count ==K:
                    result += 1
            elif space[i][j] == 0 and count == K:
                result +=1
                count = 0
            else:
                count = 0
    for i in range(N):
        count = 0
        for j in range(N):
            if space[j][i] == 1:
                count +=1
                if j==N-1 and count ==K:
                    result +=1
            elif space[j][i] == 0 and count == K:
                result +=1
                count = 0
            else:
                count = 0



    print("#" + str(time)+" "+str(result))

