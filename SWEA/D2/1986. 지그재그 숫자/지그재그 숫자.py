# 1986. 지그재그 숫자

T = int(input())
for time in range(1, T + 1):

    N = int(input())
    result =0
    for i in range(1,N+1):
        if i%2 ==0:
            result -= i
        else :
            result += i
    print("#" + str(time) +" "+str(result))