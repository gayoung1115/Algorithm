def solve(arr):
    ## 가로 탐색
    for lst in arr:
        if len(set(lst)) != 9:
            return 0
    ## 세로 줄 탐색
    line = list(zip(*arr))
    for lst in line:
        if len(set(lst)) != 9:
            return 0
    ## 3*3 직사각형 탐색
    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            lst = arr[i][j:j + 3] + arr[i + 1][j:j + 3] + arr[i + 2][j:j + 3]
            if len(set(lst)) != 9:
                return 0
    return 1
 
 
T = int(input())
for time in range(1, T + 1):
    arr = [list(map(int, input().split())) for _ in range(9)]
 
    result = solve(arr)
 
    print("#" + str(time) + " " + str(result))