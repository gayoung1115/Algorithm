# 1959. 두 개의 숫자열

T = int(input())
for time in range(1, T + 1):

    temp = []
    result = []
    N, M = map(int, input().split())

    if N > M:
        temp = list(map(int, input().split()))
        N_arr = list(map(int, input().split()))
        M_arr = temp

        N = len(N_arr)
        M = len(M_arr)
    else:
        N_arr = list(map(int, input().split()))
        M_arr = list(map(int, input().split()))

    for i in range(M - N + 1):
        ad = 0
        for j in range(N):
            ad += N_arr[j] * M_arr[(j + i)]
        result.append(ad)

    print("#" + str(time) + " " + str(max(result)))
