# 1984. 중간 평균값 구하기

T = int(input())
for time in range(1, T + 1):
    a = list(map(int,input().split()))
    a.remove(max(a))
    a.remove(min(a))

    result = round(sum(a)/len(a))




    print("#" + str(time)+" "+str(result))