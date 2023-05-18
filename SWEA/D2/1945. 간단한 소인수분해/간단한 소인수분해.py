# 1945. 간단한 소인수분해


T = int(input())
for time in range(1, T + 1):
    N = int(input())
    nu = {2:0,3:0,5:0,7:0,11:0}
    for num in nu.keys():
        while N !=1:
            if N%num!=0:
                break
            else:
                N = N // num
                nu[num] += 1
                


    print("#" + str(time),end=" ")
    print(*nu.values())