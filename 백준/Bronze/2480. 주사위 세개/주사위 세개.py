import sys
a,b,c = map(int,sys.stdin.readline().split())

if a==b==c :
    print((10000+(a*1000))) # a=b=c
elif a !=b and b!=c and a!=c :
    if a>b and a>c :
        print(a*100)
    elif b>a and b>c:
        print(b * 100)
    else :
        print(c * 100)
else :
    if a==b or a==c :
        print((1000 + (a * 100)))
    else :
        print((1000 + (b * 100)))