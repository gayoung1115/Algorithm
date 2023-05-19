T = int(input())
for time in range(1, T + 1):
    N = str(input())
    k =0
    arr = []
    while len(set(arr)) != 10:
        k += 1
        arr += list(str(k*int(N)))

    print("#" + str(time)+" "+str(k*int(N)))