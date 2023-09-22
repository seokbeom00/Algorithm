import sys
input = sys.stdin.readline
n, k = map(int, input().split())
dp = [[0]*201 for _ in range(201)]
for i in range(1, 201):
    for j in range(1, 201):
        if i == 1:
            dp[j][i] = j
        elif j == 1:
            dp[j][i] = 1
        else:
            dp[j][i] = dp[j][i-1] + dp[j-1][i]
print(dp[k][n]%1000000000)
