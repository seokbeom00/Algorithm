import sys

input = sys.stdin.readline
n = int(input())
arr = []
dp = [[0 for _ in range(2)] for _ in range(n)]
for i in range(n):
    arr.append(list(map(int, input().split())))
for i in range(n):
    if i + arr[i][0] <= n:
        dp[i][0] = arr[i][1]
        dp[i][1] = arr[i][0] + i
    for j in range(n):
        if i >= dp[j][1] and arr[i][0] + i <= n and i > j:
            dp[j][0] += arr[i][1]
            dp[j][1] = arr[i][0] + i
print(dp)
