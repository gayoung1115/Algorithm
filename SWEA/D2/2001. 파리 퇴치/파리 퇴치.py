T = int(input())
for time in range(1,T+1):

    n,m = map(int, input().split())
    space = [list(map(int,input().split())) for i in range(n)]
    kills = []  # 파리채 내려칠 곳

    for i in range(n-m+1):
        for j in range(n-m+1):
            fly = 0
            # 해당 위치를 타격했을 때 잡을 수 있는 파리의 수 탐색
            for k in range(m):
                for l in range(m):
                    fly += space[i + k][j + l]
            kills.append(fly)

    print("#"+str(time), max(kills))