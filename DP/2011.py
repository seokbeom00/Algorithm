import sys
input = sys.stdin.readline

n = input()
len = len(n) - 1
n = int(n)
dp = [[0]*10 for _ in range(len+1)]
for i in range(1, len+1):
    for j in range(1, 10):
        if i == 1:
            dp[i][j] = j
        if i == 2 and 1<=j<=6:
            dp[i][j] = 11
        if i == 2 and 7<=j<=9:
            dp[i][j] = 10
        if i>=3 and 1<=j<=6:
            dp[i][j] = sum(dp[i-1])+2
        elif i >=3 and 7<=j<=9:
            dp[i][j] = sum(dp[i-1])+1
print(dp)