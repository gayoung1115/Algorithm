T = int(input())
for time in range(1,T+1):
    a = str(input())
    result = 0
    indexMiddle = 1
    indexFinal = 0
    for i in range(1,31):
        indexFinal = a.find(a[0],indexMiddle)
        if a[0:indexFinal] == a[indexFinal:2*indexFinal]:
            result = indexFinal
            break
        else:
            indexMiddle = indexFinal+1
            continue
    print(f'#{time} {result}')