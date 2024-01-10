import sys

input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))
ans = 0
li = []
arr.sort()
for i in arr:
    ans = ans + i
    li.append(ans)
print(sum(li))
