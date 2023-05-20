def rotate(space):
    result_sp = [[0]*N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            result_sp[i][j] = space[N-j-1][i]
    return result_sp

T = int(input())
for time in range(1, T + 1):
    N = int(input())
    space = [list(map(int,input().split())) for _ in range(N)]
    space1 = rotate(space)
    space2 = rotate(space1)
    space3 = rotate(space2)
    print("#" + str(time))
    for i in range(N):
        print(''.join(str(s) for s in space1[i]),end=" ")
        print(''.join(str(s) for s in space2[i]),end=" ")
        print(''.join(str(s) for s in space3[i]),end=" ")
        print()

