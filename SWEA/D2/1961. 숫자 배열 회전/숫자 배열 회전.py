# 1961. 숫자 배열 회전

def degree(test):
    deg = [N * [0] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            deg[i][j] = test[N - 1 - j][i]
            #arr[i][j] = arr[][]의 규칙성 파악하기
    return deg

T = int(input())
for time in range(1, T + 1):
    result = []
    temp = []
    N = int(input())
    arr = [list(map(str, input().split())) for _ in range(N)]

    # 90도
    arr_90 = degree(arr)
    #180도
    arr_180 = degree(arr_90)
    #270도
    arr_270 = degree(arr_180)

    print(f'#{time}')
    for a,b,c in zip(arr_90,arr_180,arr_270):
        a1 = ''.join(map(str,a))
        b1 = ''.join(b)
        c1 = ''.join(c)
        print(a1, b1, c1)