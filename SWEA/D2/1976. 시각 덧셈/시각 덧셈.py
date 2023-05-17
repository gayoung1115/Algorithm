# 1976.시각 덧셈

T = int(input())
for time in range(1, T + 1):
    h = list(map(int, input().split()))
    hour = h[0]+h[2]
    minute = h[1]+h[3]

    if minute > 59 :
        hour += minute // 60
        minute = minute % 60
    if hour > 12 :
        hour = hour-12

    print("#" + str(time)+" "+str(hour)+" "+str(minute))