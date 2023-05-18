# 2058. 자릿수 더하기

N = str(input()) # 파이썬 형변환 str(),int(),input()
result = 0

for i in range(len(N)): # 문자열의 길이 구하기 len(변수명)->리스트, 튜플, 문자열 모두 가능
    result += int(N[i])

print(result)