import sys

input = sys.stdin.readline
n, k = map(int, input().split())
arr = []
ans = []
for i in range(n):
    arr.append(i + 1)
cur = 0
for i in range(n):
    if len(arr) < k:
        cur += k - 1
        while True:
            cur -= len(arr)
            if cur <= len(arr) - 1:
                break
        ans.append(arr.pop(cur))
        if cur == len(arr):
            cur -= 0
    else:
        cur += k - 1
        if cur > len(arr) - 1:
            cur -= len(arr)
        ans.append(arr.pop(cur))
        if cur == len(arr):
            cur = 0
print("<", end="")
for i in range(len(ans)):
    if i != len(ans) - 1:
        print(ans[i], end="")
        print(f", ", end="")
    else:
        print(ans[i], end="")
print(">", end="")
print()
