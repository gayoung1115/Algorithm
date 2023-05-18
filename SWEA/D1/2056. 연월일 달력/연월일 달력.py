# 2056. 연원일 달력

def solve():
    n = str(input())
    calls = {1: 31, 2: 28, 3: 31, 4: 30, 5: 31, 6: 30, 7: 31, 8: 31, 9: 30, 10: 31, 11: 30, 12: 31}

    year = n[0:4]
    month = n[4:6]
    day = n[6:]

    if 0 < int(month) < 13 and 0 < int(day) <= calls[int(month)]:
        temp = year+"/"+month+"/"+day
        return temp
    else:
        return -1


T = int(input())
for time in range(1, T + 1):
    result = solve()
    print("#" + str(time)+" "+str(result))