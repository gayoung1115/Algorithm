T = int(input())
for test_case in range(1, T + 1):
    result = -1
    arr = [list(map(int,input().split())) for _ in range(9)]
    sudo = []

    # 가로 검증
    for x in range(9):
        for y in range(9):
            sudo.append(arr[x][0+y])
        if len(set(sudo)) == 9:
            sudo = []
        else :
            result = 0
            break
    if result != 0:
        # 새로 검증
        for x in range(9):
            for y in range(9):
                sudo.append(arr[0+y][x])
            if len(set(sudo)) == 9:
                sudo = []
            else :
                result = 0
                break
    if result != 0:
        for x in range(0,9,3):
            for y in range(0,6,9):
                sudo = arr[x][y:y+3]+arr[x+1][y:y+3]+arr[x+2][y:y+3]
            if len(set(sudo)) == 9:
                sudo = []
            else :
                result = 0
                break

    if result == -1: result = 1

    print(f'#{test_case}',result)