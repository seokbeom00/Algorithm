import sys
input = sys.stdin.readline

n = int(input())
dp = [0]*31
dp[2] = 3
dp[4] = 11
dp[6] = 41
for i in range(8, 31):
    if i%2 == 0:
        dp[i] = dp[i-2]*3
        for j in range(i-4, 0, -2):
            dp[i] += dp[j]*2
        dp[i]+=2
    else:
        dp[i] = 0
print(dp[n])
