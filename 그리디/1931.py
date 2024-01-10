import sys

input = sys.stdin.readline
n = int(input())
arr = []
for i in range(n):
    start, end = map(int, input().split())
    arr.append((start, end))
arr = sorted(arr, key=lambda x: (x[1], x[0]))
ans = 1
standard = arr[0][1]
for i in range(1, n):
    if arr[i][0] >= standard:
        ans += 1
        standard = arr[i][1]
print(ans)
