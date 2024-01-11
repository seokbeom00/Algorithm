import sys

input = sys.stdin.readline

n, m, k = map(int, input().split())
team = 0
while True:
    if n + m - 3 >= k and n >= 2 and m >= 1:
        n -= 2
        m -= 1
        team += 1
    else:
        break
print(team)
