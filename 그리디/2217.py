import sys
import heapq

input = sys.stdin.readline
n = int(input())
w = []
for i in range(n):
    w.append(int(input()))
w = sorted(w, reverse=True)
ans = []
cnt = 1
for i in w:
    ans.append(i * cnt)
    cnt += 1
print(max(ans))
