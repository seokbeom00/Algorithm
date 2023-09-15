import sys
input = sys.stdin.readline
n = int(input())
dp = [0]*(n+1)

def rec(n):
    if n == 1:
        dp[n] = n
        return dp[n]
    if n == 2:
        dp[n] = 3
        return dp[n]
    if dp[n] > 0:
        return dp[n]
    else:
        dp[n] = rec(n-1) + rec(n-2)*2
        return dp[n]

print(rec(n)%10007)
