import sys

input = sys.stdin.readline

e, s, m = map(int, input().split())

# E, S, M에 대해 주기를 갖는 수로 변환
e = e % 15
s = s % 28
m = m % 19

year = 1
while True:
    # 현재 year 값이 E, S, M에 해당하는 값과 일치하는지 비교
    if (year % 15 == e) and (year % 28 == s) and (year % 19 == m):
        print(year)
        break
    year += 1