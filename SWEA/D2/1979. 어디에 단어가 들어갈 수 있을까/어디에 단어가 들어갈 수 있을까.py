T = int(input())
for time in range(1, T + 1):
    N,M = map(int,input().split())
    space = [list(map(str,input().split())) for _ in range(N)]
    result =[]
    count =0

    for i in range(N):
        temp = ''.join(space[i])
        temp = temp.split('0')
        result += temp

    space = list(map(list,zip(*space)))
    for i in range(N):
        temp = ''.join(space[i])
        temp = temp.split('0')
        result += temp

    for j in range(len(result)):
        if len(result[j]) ==M:
            count +=1
    print(f'#{time} {count}')
