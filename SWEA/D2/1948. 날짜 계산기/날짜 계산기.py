# 1948. 날짜 계산기
T = int(input())
for time in range(1, T + 1):
    dict_day = {1: 31, 2: 28, 3: 31, 4: 30, 5: 31, 6: 30, 7: 31, 8: 31,9:30, 10: 31, 11: 30, 12: 31}
    start_m, start_d, end_m, end_d = map(int, input().split())
    result = 0

    result += dict_day[start_m] - start_d + 1
    if start_m < end_m:
        for i in range(1, end_m - start_m):
            result += dict_day[start_m + i]
        result += end_d

    print("#" + str(time) + " " + str(result))