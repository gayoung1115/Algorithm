# 1983. 조교의 성적 매기기

T = int(input())
for time in range(1, T + 1):
    N,K = map(int, input().split())
    result = 0
    student =[]
    score = ["A+","A0","A-","B+","B0","B-","C+","C0","C-"]

    for i in range(N):
        a,b,c =map(int,input().split())
        all = round(a*0.35+b*0.45+c*0.2)
        student.append(all)
    temp = student[K - 1]

    student.sort(reverse=True)
    temp = int(student.index(temp)//(N/10)) 

    result = score[temp]

    print("#" + str(time)+" "+str(result))