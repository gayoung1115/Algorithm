T = int(input())
for time in range(1,T+1):
    string = str(input())
    if string == string[::-1]:
        result =1
    else:
        result =0

    print("#"+str(time)+" "+str(result))

