N,K = map(int,input().split()) # 참가하는 학생 수 N,  한 방 배정 K
dict ={"1_여":0,"2_여":0,"3_여":0,"4_여":0,"5_여":0,"6_여":0,
       "1_남":0,"2_남":0,"3_남":0,"4_남":0,"5_남":0,"6_남":0}
count =0

for i in range(N):
    a, b = map(int, input().split())
    if a ==0 : #여학생
        if b == 1:
            dict["1_여"] += 1
        elif b ==2:
            dict["2_여"] += 1
        elif b ==3:
            dict["3_여"] += 1
        elif b ==4:
            dict["4_여"] += 1
        elif b ==5:
            dict["5_여"] += 1
        elif b ==6:
            dict["6_여"] += 1
    else:  # 남학생
        if b == 1:
            dict["1_남"] += 1
        elif b == 2:
            dict["2_남"] += 1
        elif b == 3:
            dict["3_남"] += 1
        elif b == 4:
            dict["4_남"] += 1
        elif b == 5:
            dict["5_남"] += 1
        elif b == 6:
            dict["6_남"] += 1
for j in dict.values():
    if j%K !=0:
        count += j//K+1
    else:
        count += j // K

print(count)