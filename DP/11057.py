import sys
input = sys.stdin.readline
n = int(input())
dp = [[0]*10 for _ in range(n+1)]

for i in range(10):
    dp[1][i] = 1

for i in range(2, n+1):
    for j in range(10):
        if j == 0:
            dp[i][j] = 1
        else:
            tmp = 0
            for k in range(0, j+1):
                tmp += dp[i-1][k]
            dp[i][j] = tmp

print(sum(dp[n])%10007)