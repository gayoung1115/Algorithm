space = [[0]*1001 for _ in range(1001)]
N = int(input())
arr = [list(map(int,input().split())) for _ in range(N)]
count = 0
temp =0

for i in arr:
    for x in range(i[0],i[0]+i[2]):
        for y in range(i[1],i[1]+i[3]):
            space[x][y] += 1

for i in arr:
    count +=1
    temp = 0
    for x in range(1001):
        for y in range(1001):
            if space[x][y] == count:
                temp += 1
    print(temp)