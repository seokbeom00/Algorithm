import sys

input = sys.stdin.readline
t = int(input())
for j in range(t):
    n = int(input())
    arr = []
    for i in range(n):
        a, b = map(int, input().split())
        arr.append((a, b))
    ans = 1
    arr.sort()
    top = arr[0][1]
    for i in range(1, n):
        if arr[i][1] < top:
            top = arr[i][1]
            ans += 1
    print(ans)
