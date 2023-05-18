T = int(input())
for time in range(1, T + 1):
    coin = int(input())
    one = [50000,10000,5000,1000,500,100,50,10]
    result = []

    for i in one:
        result.append(str(coin // i))
        coin %= i

    print("#" + str(time))
    print(' '.join(result))