# 1940. 가랏! RC카!
T = int(input())
for time in range(1, T + 1):
    result = 0
    n = int(input())
    h =0
    m =0
    for i in range(n):
        a= list(map(int,input().split()))
        if a[0] == 1:
            h += a[1]
            m += h
        elif a[0] ==2 and h>0:
            h -= a[1]
            m += h
        else:
            m +=h



    print("#" + str(time)+" "+str(m))