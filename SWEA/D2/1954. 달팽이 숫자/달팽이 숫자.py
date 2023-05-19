# 1954 . 달팽이 숫자
T = int(input())

for time in range(1, T + 1):
    N = int(input())
    space = [[0] * N for _ in range(N)]
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    i, j, count, n = 0, 0, 0, 1  # n은 달팽이에 넣을 값, count는 dx,dy의 순서

    space[0][0] = n
    n += 1

    while n <= N * N:
        i += dx[count]
        j += dy[count]
        if i in range(N) and j in range(N) and space[i][j] == 0:  # 순서 주의 arr[ni][nj]==0 조건이 먼저일 경우 인덱스 초과로 오류남
            space[i][j] = n
            n += 1
        else:
            i -= dx[count]
            j -= dy[count]
            count = (count + 1) % 4
    print("#" + str(time))
    for k in space:
        print(*k)

