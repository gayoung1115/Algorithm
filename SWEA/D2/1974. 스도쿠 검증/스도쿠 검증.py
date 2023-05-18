T = int(input())
for time in range(1, T + 1):
    result = 0
    sodo = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    temp = []
    arr = [list(map(int, input().split())) for _ in range(9)]

    for k in range(0, 9, 3):
        for p in range(0,9,3):
            for i in range(3):
                for j in range(3):
                    temp.append(arr[i+k][j+p])
            temp.sort()
            if sodo == temp:
                result+=1
            temp =[]

    for i in range(9):
        for j in range(9):
            temp.append(arr[i][j])
        temp.sort()
        if sodo == temp:
            result += 1
        temp = []
    for i in range(9):
        for j in range(9):
            temp.append(arr[j][i])
        temp.sort()
        if sodo == temp:
            result += 1
        temp = []
    if result == 27:
        result = 1
    else :
        result = 0

    print("#" + str(time) + " " + str(result))
