# 1284. 수도 요금 경쟁

T = int(input())
for time in range(1, T + 1):
    P, Q, R, S, W = map(int,input().split())
    result =[]

    result.append(W*P)
    if R >= W:
        result.append(Q)
    else:
        result.append((W-R)*S+Q)

    print("#" + str(time)+" "+str(min(result)))
