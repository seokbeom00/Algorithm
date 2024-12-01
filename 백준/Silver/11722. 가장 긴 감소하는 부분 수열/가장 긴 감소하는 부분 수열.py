import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
dp = [1]*(n+1)
for i in range(1, n):
    for j in range(i):
        if arr[j]>arr[i] and dp[j]>=dp[i]:
            dp[i] = dp[i]+1
print(max(dp))