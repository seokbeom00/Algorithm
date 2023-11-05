import sys

input = sys.stdin.readline
m, n = map(int, input().split())
for i in range(m, n + 1):
    for j in range(i - 1, 1, -1):
        if i % j == 0:
            break
        if j == 2:
            print(i)
