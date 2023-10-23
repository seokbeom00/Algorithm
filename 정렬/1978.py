import sys

input = sys.stdin.readline
n = int(input())
list = list(map(int, input().split()))
ans = 0
for i in range(n):
    if list[i] == 1:
        continue
    tmp = list[i]
    for j in range(list[i] - 1, 1, -1):
        if tmp % j == 0:
            tmp = tmp // j
            break
    if tmp == list[i]:
        ans += 1
print(ans)
