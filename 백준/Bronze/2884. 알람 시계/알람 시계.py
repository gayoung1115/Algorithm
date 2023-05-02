import sys
h,m = map(int, sys.stdin.readline().split())

if m-45 < 0:
    if h > 0:
        h = h-1
        m = (m+60)-45
    elif h == 0:
        h = 23
        m = (m + 60) - 45
else :
    m = m-45
print(h,m)
