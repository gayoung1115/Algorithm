T=int(input())
for i in range(1,T+1):
    arr = [i for i in map(int,input().split())]
    a = round(sum(arr)/10)

    print("#"+str(i)+" "+str(a))